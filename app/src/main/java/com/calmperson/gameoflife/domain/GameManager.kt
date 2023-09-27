package com.calmperson.gameoflife.domain

import android.graphics.Point
import android.util.Log
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.NeighborhoodType
import com.calmperson.gameoflife.model.NeighborhoodType.*
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sin
import kotlin.math.sqrt

class GameManager {

    companion object {
        private const val DEFAULT_AGE = 0
    }

    var generation = 0
    
    var aliveCells = 0
    var deadCells = 0
    var oldestCell = 0

    fun nextGeneration(
        oldGeneration: Array<Array<Cell>>,
        neighborhoodType: NeighborhoodType,
        neighborhoodRange: Int,
        survivalRange: IntRange,
        revivalNeighborCount: Int,
    ): Array<Array<Cell>> {
        val height = oldGeneration.size
        val width = oldGeneration[height - 1].size
        val nextGeneration = Array(height) { Array(width) { Cell(false, DEFAULT_AGE) } }

        restStats()

        for (y in 0 until height) {
            for (x in 0 until width) {

                val aliveNeighboursCount = countAliveNeighbours(
                    oldGeneration, y, x, height, width, neighborhoodRange, neighborhoodType
                )

                if (oldGeneration[y][x].isAlive) {
                    nextGeneration[y][x].isAlive = aliveNeighboursCount in survivalRange
                    nextGeneration[y][x].age = increaseAge(oldGeneration[y][x].age)
                } else {
                    if (aliveNeighboursCount == revivalNeighborCount) {
                        nextGeneration[y][x].isAlive = true
                        nextGeneration[y][x].age = increaseAge(oldGeneration[y][x].age)
                    } else {
                        nextGeneration[y][x].isAlive = false
                        nextGeneration[y][x].age = DEFAULT_AGE
                    }
                }

                updateStats(nextGeneration[y][x])
            }
        }
        generation++
        return nextGeneration
    }

    fun createGameField(height: Int, width: Int): Array<Array<Cell>> {
        return Array(height) { Array(width) { Cell(false, DEFAULT_AGE) } }
    }

    fun resizeGameField(
        gameField: Array<Array<Cell>>?,
        height: Int,
        width: Int
    ): Array<Array<Cell>> {
        return if (gameField == null) {
            Array(height) { Array(width) { Cell(false, DEFAULT_AGE) } }
        } else {
            Array(height) { i ->
                Array(width) { j ->
                    try {
                        gameField[i][j]
                    } catch (e: IndexOutOfBoundsException) {
                        Cell(false, DEFAULT_AGE)
                    }
                }
            }
        }
    }

    fun reset(gameFieldHeight: Int, gameFieldWidth: Int): Array<Array<Cell>> {
        restStats()
        generation = 0
        return Array(gameFieldHeight) { Array(gameFieldWidth) { Cell(false, DEFAULT_AGE) } }
    }

    fun addCells(
        gameField: Array<Array<Cell>>,
        yCenter: Int,
        xCenter: Int,
        areaRange: Int,
        neighborhoodType: NeighborhoodType
    ): Array<Array<Cell>> {
        if (yCenter < 0 || xCenter < 0) return gameField
        val height = gameField.size
        val width = gameField[0].size
        return gameField.copyOf().apply {
            if (areaRange == 0) {
                this[yCenter][xCenter].isAlive = true
                return this
            }

            iterateArrayRegionAroundCenter(
                yCenter, xCenter, areaRange,
                this, height, width
            ) { y, x, cell ->
                applyActionInRegion(
                    yCenter, xCenter,
                    y, x,
                    neighborhoodType,
                    areaRange,
                    action = {
                        cell.isAlive = true
                    }
                )
            }
        }
    }

    private fun countAliveNeighbours(
        oldGeneration: Array<Array<Cell>>,
        yCenter: Int,
        xCenter: Int,
        height: Int,
        width: Int,
        neighborhoodRange: Int,
        neighborhoodType: NeighborhoodType,
    ): Int {
        var aliveNeighborsCount = 0

        iterateArrayRegionAroundCenter(
            yCenter, xCenter, neighborhoodRange,
            oldGeneration, height, width
        ) { y, x, cell ->
            applyActionInRegion(
                yCenter, xCenter,
                y, x,
                neighborhoodType,
                neighborhoodRange,
                action = {
                    if (!(y == yCenter && x == xCenter)) {
                        if (cell.isAlive) aliveNeighborsCount++
                    }
                }
            )
        }

        return aliveNeighborsCount
    }

    private fun applyActionInRegion(
        yCenter: Int,
        xCenter: Int,
        y: Int,
        x: Int,
        neighborhoodType: NeighborhoodType,
        neighborhoodRange: Int,
        action: () -> Unit
    ) {
        val y1 = abs(yCenter - y)
        val x1 = abs(xCenter - x)
        when (neighborhoodType) {
            MOORE -> {
                action.invoke()
            }
            VON_NEUMANN -> {
                val distance = y1 + x1
                if (distance <= neighborhoodRange) {
                    action.invoke()
                }
            }
            CHECKERBOARD -> {
                if ((y % 2 == 0) xor (x % 2 == 0)) action.invoke()
            }
            ALIGNED_CHECKERBOARD -> {
                if ((y % 2 == 0) xor (x % 2 != 0))  action.invoke()
            }
            L2 -> {
                val distance = sqrt(x1.toDouble().pow(2) + y1.toDouble().pow(2))
                if (distance <= neighborhoodRange) {
                    action.invoke()
                }
            }
            CROSS -> {
                if ((y == yCenter || x == xCenter)) action.invoke()
            }
            SALTIRE -> {
                if (y1 == x1) action.invoke()
            }
            STAR -> {
                if (y1 == x1 || y1 == 0 || x1 == 0) action.invoke()
            }
            HASH -> {
                if (y1 == 1 || x1 == 1) action.invoke()
            }
        }
    }

    private fun <T> iterateArrayRegionAroundCenter(
        yCenter: Int,
        xCenter: Int,
        regionRange: Int,
        array: Array<Array<T>>,
        height: Int,
        width: Int,
        onEach: (Int, Int, T) -> Unit
    ) {
        val topLeftY = (yCenter - regionRange + height) % height
        val topLeftX = (xCenter - regionRange + width) % width

        val bottomRightY = (yCenter + regionRange) % height
        val bottomRightX = (xCenter + regionRange) % width

        var y = topLeftY
        do {
            if (y == height) {
                if (bottomRightY in (height - 1)..height) break
                y = 0
            }
            var x = topLeftX
            do {
                if (x == width) {
                    if (bottomRightX in (width - 1)..width) break
                    x = 0
                }
                onEach(y, x, array[y][x])
                x++
            } while (x != bottomRightX + 1)
            y++
        } while (y != bottomRightY + 1)
    }

    private fun updateStats(cell: Cell) {
        if (cell.isAlive) aliveCells++ else deadCells++
        oldestCell = if (cell.age > oldestCell) cell.age else oldestCell
    }

    private fun restStats() {
        aliveCells = 0
        deadCells = 0
        oldestCell = 0
    }

    private fun increaseAge(age: Int): Int {
        return age + 1
    }

}