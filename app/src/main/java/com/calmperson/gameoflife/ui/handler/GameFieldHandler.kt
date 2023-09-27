package com.calmperson.gameoflife.ui.handler

import com.calmperson.gameoflife.domain.GameEngine
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.ScreenSize
import com.calmperson.gameoflife.util.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameFieldHandler(
    private val gameEngine: GameEngine
) {

    private val _isPaintingModeEnable: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isPaintingModeEnable: StateFlow<Boolean>
        get() = _isPaintingModeEnable

    val gameField: StateFlow<Array<Array<Cell>>?> = gameEngine.gameField

    fun addCells(yCenter: Int, xCenter: Int) {
        gameEngine.addCells(yCenter, xCenter)
    }

    fun enablePaintingMode() {
        _isPaintingModeEnable.value = true
    }

    fun disablePaintingMode() {
        _isPaintingModeEnable.value = false
    }

}