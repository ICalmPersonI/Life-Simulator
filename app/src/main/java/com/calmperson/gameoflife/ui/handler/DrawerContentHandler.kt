package com.calmperson.gameoflife.ui.handler

import com.calmperson.gameoflife.domain.GameEngine
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.GameRules
import com.calmperson.gameoflife.model.GameSettings
import com.calmperson.gameoflife.model.GameStats
import com.calmperson.gameoflife.model.NeighborhoodType
import com.calmperson.gameoflife.model.ScreenSize
import com.calmperson.gameoflife.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DrawerContentHandler(
    private val gameEngine: GameEngine,
    private val screenSize: ScreenSize
) {

    val gameStatistics: StateFlow<GameStats> = gameEngine.gameStats
    val gameRules: StateFlow<GameRules> = gameEngine.gameRules
    val gameSettings: StateFlow<GameSettings> = gameEngine.gameSettings
    val neighborhoodTypeVisualisation: StateFlow<Array<Array<Cell>>> = gameEngine.neighborhoodTypeVisualisation

    fun changeCellSize(size: Float) {
        gameEngine.setCellSize(size)
        resizeGameField()
    }

    fun changeCellClusterThickness(thickness: Int) {
        gameEngine.setCellClusterThickness(thickness)
    }

    fun changeGameSpeed(speed: Int) {
        gameEngine.setGameSpeed(speed)
    }

    fun changeNeighborhoodType(type: NeighborhoodType) {
        gameEngine.setNeighborhoodType(type)
    }

    fun changeNeighborhoodRange(range: Int) {
        gameEngine.setNeighborhoodRange(range)
    }

    fun changeSurvivalRange(range: IntRange) {
        gameEngine.setSurvivalRange(range)
    }

    fun changeRevivalNeighborCount(count: Int) {
        gameEngine.setRevivalNeighborCount(count)
    }

    fun startGame() {
        gameEngine.start()
    }

    fun stopGame() {
        gameEngine.stop()
    }

    fun resetGame() {
        gameEngine.reset()
    }

    private fun resizeGameField() {
        gameEngine.resizeGameField(screenSize)
    }

}