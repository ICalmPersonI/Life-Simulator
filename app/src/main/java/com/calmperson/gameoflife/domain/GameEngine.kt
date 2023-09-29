package com.calmperson.gameoflife.domain

import com.calmperson.gameoflife.data.local.DataManager
import com.calmperson.gameoflife.data.mapper.JsonMapper.fromJson
import com.calmperson.gameoflife.data.mapper.JsonMapper.toJson
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.GameRules
import com.calmperson.gameoflife.model.GameSettings
import com.calmperson.gameoflife.model.GameStats
import com.calmperson.gameoflife.model.NeighborhoodType
import com.calmperson.gameoflife.model.ScreenSize
import com.calmperson.gameoflife.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GameEngine @Inject constructor(
    private val gameManager: GameManager,
    private val dataManager: DataManager
) {

    companion object {
        private val DEFAULT_NEIGHBORHOOD_TYPE = NeighborhoodType.MOORE
        private val DEFAULT_SURVIVAL_RANGE = 2..3
        private const val DEFAULT_NEIGHBORHOOD_RANGE = 1
        private const val DEFAULT_CELL_SIZE = 10f
        private const val DEFAULT_GAME_SPEED = 10
        private const val DEFAULT_LINE_THICKNESS = 1
        private const val DEFAULT_REVIVAL_NEIGHBOR_COUNT = 3
        private const val MIN_DELAY = 1L
        private const val MAX_DELAY = 1000L
        private const val NEIGHBORHOOD_TYPE_VISUALISATION_MATRIX_SIZE = 20
        private const val GAME_FIELD_SAVE_FILE_NAME = "gameField.data"
        private const val GAME_STATS_SAVE_FILE_NAME = "gameStats.data"
        private const val GAME_SETTINGS_SAVE_FILE_NAME = "gameSettings.data"
        private const val GAME_RULES_SAVE_FILE_NAME = "gameRules.data"
        private val DEFAULT_GAME_STATS = GameStats()
        private val DEFAULT_GAME_SETTINGS = GameSettings(
            DEFAULT_LINE_THICKNESS, DEFAULT_GAME_SPEED, DEFAULT_CELL_SIZE
        )
        private val DEFAULT_GAME_RULES = GameRules(
            DEFAULT_NEIGHBORHOOD_TYPE, DEFAULT_NEIGHBORHOOD_RANGE,
            DEFAULT_SURVIVAL_RANGE, DEFAULT_REVIVAL_NEIGHBOR_COUNT
        )
    }

    private val _gameField: MutableStateFlow<Array<Array<Cell>>?> = MutableStateFlow(null)
    val gameField: StateFlow<Array<Array<Cell>>?>
        get() = _gameField

    private val _gameStats: MutableStateFlow<GameStats> = MutableStateFlow(DEFAULT_GAME_STATS)
    val gameStats: StateFlow<GameStats>
        get() = _gameStats

    private val _gameSettings: MutableStateFlow<GameSettings> = MutableStateFlow(DEFAULT_GAME_SETTINGS)
    val gameSettings: StateFlow<GameSettings>
        get() = _gameSettings

    private val _gameRules: MutableStateFlow<GameRules> = MutableStateFlow(DEFAULT_GAME_RULES)
    val gameRules: StateFlow<GameRules>
        get() = _gameRules

    private val _neighborhoodTypeVisualisation: MutableStateFlow<Array<Array<Cell>>> = MutableStateFlow(
        gameManager.createGameField(
            NEIGHBORHOOD_TYPE_VISUALISATION_MATRIX_SIZE,
            NEIGHBORHOOD_TYPE_VISUALISATION_MATRIX_SIZE
        )
    )
    val neighborhoodTypeVisualisation: StateFlow<Array<Array<Cell>>>
        get() = _neighborhoodTypeVisualisation

    private var isGameRunning = false
    private var delay: Long = calculateDelay(DEFAULT_GAME_SPEED)

    init {
        updateNeighborhoodTypeVisualisation()
    }

    fun createGameField(screenSize: ScreenSize) {
        val (height, width) = Utils.calculateGameFieldDimensions(_gameSettings.value.cellSize, screenSize)
        _gameField.value = gameManager.createGameField(height, width)
    }

    fun resizeGameField(screenSize: ScreenSize) {
        val (height, width) = Utils.calculateGameFieldDimensions(_gameSettings.value.cellSize, screenSize)
        _gameField.value = gameManager.resizeGameField(_gameField.value, height, width)
    }

    fun start() {
        if (!isGameRunning && _gameField.value != null) {
            isGameRunning = true
            CoroutineScope(Dispatchers.Default).launch {
                gameManager.generation = 0
                while (isGameRunning) {
                    val newGeneration = gameManager.nextGeneration(
                        _gameField.value!!,
                        _gameRules.value.neighborhoodType,
                        _gameRules.value.neighborhoodRange,
                        _gameRules.value.cellSurvivalRange,
                        _gameRules.value.cellRevivalNeighboursCount
                    )
                    _gameField.value = newGeneration
                    updateGameStats()
                    delay(delay)
                }
            }
        }
    }

    fun stop() {
        isGameRunning = false
    }

    fun reset() {
        _gameField.value?.let { field ->
            val h = field.size
            val w = field[0].size
            _gameField.value = gameManager.reset(h, w)
        }
        _gameStats.value = DEFAULT_GAME_STATS
        _gameRules.value = DEFAULT_GAME_RULES
        _gameSettings.value = DEFAULT_GAME_SETTINGS
    }

    fun addCells(yCenter: Int, xCenter: Int) {
        _gameField.value?.let { field ->
            _gameField.value = gameManager.addCells(
                field, yCenter, xCenter,
                _gameSettings.value.cellClusterThickness - 1,
                _gameRules.value.neighborhoodType
            )
        }
    }

    fun setCellSize(size: Float) {
        _gameSettings.value = _gameSettings.value.copy(cellSize = size)
    }

    fun setGameSpeed(speed: Int) {
        _gameSettings.value = _gameSettings.value.copy(gameSpeed = speed)
        delay = calculateDelay(speed)
    }

    fun setCellClusterThickness(thickness: Int) {
        _gameSettings.value = _gameSettings.value.copy(cellClusterThickness = thickness)
    }

    fun setNeighborhoodType(type: NeighborhoodType) {
        _gameRules.value = _gameRules.value.copy(neighborhoodType = type)
        updateNeighborhoodTypeVisualisation()
    }

    fun setNeighborhoodRange(range: Int) {
        _gameRules.value = _gameRules.value.copy(neighborhoodRange = range)
        updateNeighborhoodTypeVisualisation()
    }

    fun setSurvivalRange(range: IntRange) {
        _gameRules.value = _gameRules.value.copy(cellSurvivalRange = range)
    }

    fun setRevivalNeighborCount(count: Int) {
        _gameRules.value = _gameRules.value.copy(cellRevivalNeighboursCount = count)
    }

    private fun updateGameStats() {
        with(gameManager) {
            _gameStats.value = GameStats(aliveCells, deadCells, generation, oldestCell)
        }
    }

    private fun calculateDelay(selectedSpeed: Int): Long {
        return MIN_DELAY + ((MAX_DELAY - MIN_DELAY) / selectedSpeed)
    }

    private fun updateNeighborhoodTypeVisualisation() {
        val center = NEIGHBORHOOD_TYPE_VISUALISATION_MATRIX_SIZE / 2
        val size = NEIGHBORHOOD_TYPE_VISUALISATION_MATRIX_SIZE
        _neighborhoodTypeVisualisation.value = gameManager.createGameField(size, size)
        gameManager.addCells(
            _neighborhoodTypeVisualisation.value,
            center,
            center,
            _gameRules.value.neighborhoodRange,
            _gameRules.value.neighborhoodType
        )
    }

    fun saveGameField() {
        dataManager.saveData(_gameField.value, GAME_FIELD_SAVE_FILE_NAME)
    }

    fun loadGameField(screenSize: ScreenSize) {
        dataManager.loadData(Array<Array<Cell>>::class, GAME_FIELD_SAVE_FILE_NAME)?.let { field ->
            _gameField.value = field
            resizeGameField(screenSize)
        } ?: run {
            createGameField(screenSize)
        }
    }

    fun saveGameRules() {
        val json = _gameRules.value.toJson()
        dataManager.saveData(json, GAME_RULES_SAVE_FILE_NAME)
    }

    fun loadGameRules() {
        _gameRules.value = dataManager
            .loadData(String::class, GAME_RULES_SAVE_FILE_NAME)?.let { json ->
                fromJson(json, GameRules::class.java)
            } ?: DEFAULT_GAME_RULES
    }

    fun saveSettings() {
        val json = _gameSettings.value.toJson()
        dataManager.saveData(json, GAME_SETTINGS_SAVE_FILE_NAME)
    }

    fun loadGameSettings() {
        _gameSettings.value = dataManager
            .loadData(String::class, GAME_SETTINGS_SAVE_FILE_NAME)?.let { json ->
                fromJson(json, GameSettings::class.java)
            } ?: DEFAULT_GAME_SETTINGS
        delay = calculateDelay(_gameSettings.value.gameSpeed)
    }

    fun saveGameStats() {
        val json = _gameStats.value.toJson()
        dataManager.saveData(json, GAME_STATS_SAVE_FILE_NAME)
    }

    fun loadGameStats() {
        _gameStats.value = dataManager
            .loadData(String::class, GAME_STATS_SAVE_FILE_NAME)?.let { json ->
                fromJson(json, GameStats::class.java)
            } ?: DEFAULT_GAME_STATS
    }

}