package com.calmperson.gameoflife

import com.calmperson.gameoflife.domain.GameManager
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.NeighborhoodType
import org.junit.Assert
import org.junit.Test
import kotlin.AssertionError

class GameManagerTest {

    private val gameManager = GameManager()

    @Test
    fun testAddCellsMooreRangeZeroStartPointCenterWithAllNeighborhoodTypes() {
        val expected = ExpectedValues.rangeZeroStartPointCenter
        for (type in NeighborhoodType.values()) {
            testAddCellsMethod(3, 1, 1, 0, expected, type)
        }
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointCenter() {
        val expected = ExpectedValues.mooreRangeOneStartPointCenter
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeFiveStartPointCenter() {
        val expected = ExpectedValues.mooreRangeFiveStartPointCenter
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointTopLeft() {
        val expected = ExpectedValues.mooreRangeOneStartPointTopLeft
        testAddCellsMethod(5, 0, 0, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointTop() {
        val expected = ExpectedValues.mooreRangeOneStartPointTop
        testAddCellsMethod(5, 0, 2, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointTopRight() {
        val expected = ExpectedValues.mooreRangeOneStartPointTopRight
        testAddCellsMethod(5, 0, 4, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointRight() {
        val expected = ExpectedValues.mooreRangeOneStartPointRight
        testAddCellsMethod(5, 2, 4, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointBottomRight() {
        val expected = ExpectedValues.mooreRangeOneStartPointBottomRight
        testAddCellsMethod(5, 4, 4, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointBottom() {
        val expected = ExpectedValues.mooreRangeOneStartPointBottom
        testAddCellsMethod(5, 4, 2, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointBottomLeft() {
        val expected = ExpectedValues.mooreRangeOneStartPointBottomLeft
        testAddCellsMethod(5, 4, 0, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsMooreRangeOneStartPointLeft() {
        val expected = ExpectedValues.mooreRangeOneStartPointLeft
        testAddCellsMethod(5, 2, 0, 1, expected, NeighborhoodType.MOORE)
    }

    @Test
    fun testAddCellsVonNeumannRangeOneStartPointCenter() {
        val expected = ExpectedValues.conNeumannRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.VON_NEUMANN)
    }

    @Test
    fun testAddCellsVonNeumannRangeFiveStartPointCenter() {
        val expected = ExpectedValues.vonNeumannRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.VON_NEUMANN)
    }

    @Test
    fun testAddCellsCheckerboardRangeOneStartPointCenter() {
        val expected = ExpectedValues.checkerboardRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.CHECKERBOARD)
    }

    @Test
    fun testAddCellsCheckerboardRangeFiveStartPointCenter() {
        val expected = ExpectedValues.checkerboardRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.CHECKERBOARD)
    }

    @Test
    fun testAddCellsAlignedCheckerboardRangeOneStartPointCenter() {
        val expected = ExpectedValues.alignedCheckerboardRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.ALIGNED_CHECKERBOARD)
    }

    @Test
    fun testAddCellsAlignedCheckerboardRangeFiveStartPointCenter() {
        val expected = ExpectedValues.alignedCheckerboardRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.ALIGNED_CHECKERBOARD)
    }

    @Test
    fun testAddCellsL2RangeOneStartPointCenter() {
        val expected = ExpectedValues.l2RangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.L2)
    }

    @Test
    fun testAddCellsL2RangeFiveStartPointCenter() {
        val expected = ExpectedValues.l2RangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.L2)
    }

    @Test
    fun testAddCellsCrossRangeOneStartPointCenter() {
        val expected = ExpectedValues.crossRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.CROSS)
    }

    @Test
    fun testAddCellCrossRangeFiveStartPointCenter() {
        val expected = ExpectedValues.crossRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.CROSS)
    }

    @Test
    fun testAddCellsSaltireRangeOneStartPointCenter() {
        val expected = ExpectedValues.saltireRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.SALTIRE)
    }

    @Test
    fun testAddCellSaltireRangeFiveStartPointCenter() {
        val expected = ExpectedValues.saltireRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.SALTIRE)
    }

    @Test
    fun testAddCellsStarRangeOneStartPointCenter() {
        val expected = ExpectedValues.starRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.STAR)
    }

    @Test
    fun testAddCellStarRangeFiveStartPointCenter() {
        val expected = ExpectedValues.starRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.STAR)
    }

    @Test
    fun testAddCellsHashRangeOneStartPointCenter() {
        val expected = ExpectedValues.hashRangeOne
        testAddCellsMethod(3, 1, 1, 1, expected, NeighborhoodType.HASH)
    }

    @Test
    fun testAddCellHashRangeFiveStartPointCenter() {
        val expected = ExpectedValues.hashRangeFive
        testAddCellsMethod(11, 6, 6, 5, expected, NeighborhoodType.HASH)
    }

    @Test
    fun testCreateGameField() {
        val h = 20
        val w = 20
        val result = gameManager.createGameField(h, w)
        Assert.assertEquals(h, result.size)
        Assert.assertEquals(w, result[h - 1].size)
    }

    @Test
    fun testResizeGameField() {
        val gameField = Array(10) { Array(10) { i -> Cell(i % 2 == 0, 0) } }
        val expected = ExpectedValues.resizedGameField
        val result = gameManager.resizeGameField(gameField, expected.size, expected[0].size)
        Assert.assertArrayEquals(expected, result)
    }

    @Test
    fun testResetGameField() {
        val expected = ExpectedValues.clearGameField
        val result = gameManager.reset(expected.size, expected[0].size)
        Assert.assertArrayEquals(expected, result)
    }

    private fun testAddCellsMethod(
        gameFieldSize: Int,
        yCenter: Int,
        xCenter: Int,
        range: Int,
        expected: Array<Array<Cell>>,
        neighborhoodType: NeighborhoodType
    ) {
        val gameField = Array(gameFieldSize) {
            Array(gameFieldSize) { Cell(false, 0) }
        }
        val result = gameManager.addCells(gameField, yCenter, xCenter, range, neighborhoodType)
        try {
            Assert.assertArrayEquals(expected, result)
        } catch (e: AssertionError) {
            System.err.println("Neighborhood type is: $neighborhoodType")
            throw AssertionError(e)
        }
    }
}