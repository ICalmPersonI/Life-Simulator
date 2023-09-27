package com.calmperson.gameoflife

import com.calmperson.gameoflife.model.Cell

object ExpectedValues {
    val rangeZeroStartPointCenter = arrayOf(
        Array(3) { Cell(false, 0) },
        Array(3) { i -> Cell(i == 1, 0) },
        Array(3) { Cell(false, 0) }
    )
    val mooreRangeOneStartPointCenter = Array(3) {
        Array(3) { Cell(true, 0) }
    }
    val mooreRangeFiveStartPointCenter = Array(11) {
        Array(11) { Cell(true, 0) }
    }
    val mooreRangeOneStartPointTopLeft = arrayOf(
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val mooreRangeOneStartPointTop = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val mooreRangeOneStartPointTopRight = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
    )
    val mooreRangeOneStartPointRight = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
    )
    val mooreRangeOneStartPointBottomRight = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), ),
    )
    val mooreRangeOneStartPointBottom = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val mooreRangeOneStartPointBottomLeft = arrayOf(
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val mooreRangeOneStartPointLeft = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
    )
    val conNeumannRangeOne = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0) ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0) ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0,) )
    )
    val vonNeumannRangeFive = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), )
    )
    val checkerboardRangeOne = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val checkerboardRangeFive = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val alignedCheckerboardRangeOne = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val alignedCheckerboardRangeFive = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val l2RangeOne = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val l2RangeFive = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val crossRangeOne = arrayOf(
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
    )
    val crossRangeFive = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
    )
    val saltireRangeOne = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val saltireRangeFive = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val starRangeOne = arrayOf(
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
    )
    val starRangeFive = arrayOf(
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), ),
    )
    val hashRangeOne = arrayOf(
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(false, 0), Cell(true, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
    )
    val hashRangeFive = arrayOf(
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), Cell(true, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
        arrayOf(Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(true, 0), Cell(false, 0), Cell(false, 0), Cell(false, 0), ),
    )
    val resizedGameField = Array(5) { Array(5) { i -> Cell(i % 2 == 0, 0) } }
    val clearGameField = Array(10) { Array(10) { Cell(false, 0) } }

}