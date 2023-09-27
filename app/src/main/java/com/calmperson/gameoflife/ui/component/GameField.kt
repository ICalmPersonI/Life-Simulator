package com.calmperson.gameoflife.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import com.calmperson.gameoflife.model.Cell
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.roundToInt
import kotlin.random.Random


@Composable
fun GameField(
    modifier: Modifier,
    data: StateFlow<Array<Array<Cell>>?>,
    cellSize: Float,
    isPaintingModeEnable: Boolean,
    onClick: (Int, Int) -> Unit
) {

    val calculatePointOfClick: (Offset) -> Unit = { offset ->
        val y = (offset.y / cellSize).roundToInt()
        val x = (offset.x / cellSize).roundToInt()
        onClick.invoke(y, x)
    }
    data.collectAsState().value?.let { gameField ->
        GameFieldCanvas(
            modifier = modifier,
            gameField = gameField,
            cellSize = cellSize,
            isPaintingModeEnable = isPaintingModeEnable,
            addCellToField = calculatePointOfClick,
        )
    }
}

@Composable
private fun GameFieldCanvas(
    modifier: Modifier = Modifier,
    gameField: Array<Array<Cell>>,
    cellSize: Float,
    isPaintingModeEnable: Boolean,
    addCellToField: (Offset) -> Unit,
) {
    Canvas(
        modifier = if (isPaintingModeEnable) modifier
            .pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    addCellToField.invoke(change.position)
                }
            }
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    addCellToField.invoke(offset)
                }
            }
        else modifier
    ) {

        for (y in gameField.indices) {
            for (x in 0 until gameField[y].lastIndex) {

                val cell = gameField[y][x]
                val color = if (cell.isAlive) getColorById(cell.age) else Color.Transparent

                drawRect(
                    color = color,
                    topLeft = Offset(x * cellSize, y * cellSize),
                    size = Size(cellSize, cellSize)
                )

            }
        }
    }
}

fun getColorById(id: Int): Color {
    val random = Random(id)
    return Color(
        random.nextInt(-255, 255),
        random.nextInt(-255, 255),
        random.nextInt(-255, 255),
        255
    )
}

