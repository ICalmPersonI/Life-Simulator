package com.calmperson.gameoflife.util

import com.calmperson.gameoflife.model.ScreenSize
import kotlin.math.roundToInt

object Utils {

    fun calculateGameFieldDimensions(cellSize: Float, screenSize: ScreenSize): Pair<Int, Int> {
        val height = (screenSize.height / cellSize).roundToInt()
        val width = (screenSize.width / cellSize).roundToInt()
        return Pair(height, width)
    }

}