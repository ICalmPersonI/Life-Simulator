package com.calmperson.gameoflife.ui.component

import androidx.annotation.IntegerRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calmperson.gameoflife.R
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.GameRules
import com.calmperson.gameoflife.model.GameSettings
import com.calmperson.gameoflife.model.GameStats
import com.calmperson.gameoflife.model.NeighborhoodType
import com.calmperson.gameoflife.ui.theme.GameOfLifeTheme

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    gameStats: GameStats,
    gameRules: GameRules,
    gameSettings: GameSettings,
    neighborhoodTypeVisualisation: Array<Array<Cell>>,
    changeGameSpeed: (Float) -> Unit,
    changeCellSize: (Float) -> Unit,
    changeCellClusterThickness: (Float) -> Unit,
    changeNeighborhoodType: (NeighborhoodType) -> Unit,
    changeNeighborhoodRange: (Float) -> Unit,
    changeSurvivalRange: (Float) -> Unit,
    changeRevivalNeighborCount: (Float) -> Unit,
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onResetButtonClick: () -> Unit
) {
    val verticalScrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxHeight()
            .background(color = Color.DarkGray)
            .padding(10.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Column(
            modifier = Modifier.weight(1f, false)
                .verticalScroll(verticalScrollState)
        ) {
            Container(
                label = stringResource(R.string.game_rules)
            ) {
                GameRules(
                    modifier = Modifier,
                    neighborhoodTypeVisualisation = neighborhoodTypeVisualisation,
                    neighborhoodType = gameRules.neighborhoodType,
                    neighborhoodRange = gameRules.neighborhoodRange,
                    survivalRange = gameRules.cellSurvivalRange,
                    revivalNeighborCount = gameRules.cellRevivalNeighboursCount,
                    changeNeighborhoodType = changeNeighborhoodType,
                    changeNeighborhoodRange = changeNeighborhoodRange,
                    changeSurvivalRange = changeSurvivalRange,
                    changeRevivalNeighborCount = changeRevivalNeighborCount
                )
            }
            Container(
                label = stringResource(R.string.game_statistics)
            ) {
                GameStats(
                    modifier = Modifier,
                    gameStats = gameStats
                )
            }
            Container(
                label = stringResource(R.string.settings)
            ) {
                Settings(
                    modifier = Modifier,
                    cellClusterThickness = gameSettings.cellClusterThickness,
                    changeCellClusterThickness = changeCellClusterThickness,
                    gameSpeed = gameSettings.gameSpeed,
                    changeGameSpeed = changeGameSpeed,
                    cellSize = gameSettings.cellSize,
                    changeCellSize = changeCellSize
                )
            }
        }
        ControlButtons(
            modifier = Modifier
                .padding(top = 10.dp)
                .height(dimensionResource(R.dimen.control_buttons_height)),
            onStartButtonClick = onStartButtonClick,
            onStopButtonClick = onStopButtonClick,
            onResetButtonClick = onResetButtonClick
        )
    }
}

@Composable
private fun GameRules(
    modifier: Modifier = Modifier,
    neighborhoodType: NeighborhoodType,
    neighborhoodTypeVisualisation: Array<Array<Cell>>,
    neighborhoodRange: Int,
    survivalRange: IntRange,
    revivalNeighborCount: Int,
    changeNeighborhoodType: (NeighborhoodType) -> Unit,
    changeNeighborhoodRange: (Float) -> Unit,
    changeSurvivalRange: (Float) -> Unit,
    changeRevivalNeighborCount: (Float) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Row {
            TextView(
                modifier = Modifier.align(Alignment.CenterVertically),
                text = stringResource(R.string.neighborhood_type)
            )
            DropDownMenu(
                selectedItem = neighborhoodType,
                items = NeighborhoodType.values().toList(),
                onItemClick = changeNeighborhoodType
            )
        }
        Row {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                val neighborhoodRangeSliderRange = floatRangeFromIntegers(
                    R.integer.min_neighborhood_range,
                    R.integer.max_neighborhood_range
                )
                TextView(text = stringResource(R.string.neighborhood_range))
                Slider(
                    value = neighborhoodRange.toFloat(),
                    onValueChange = changeNeighborhoodRange,
                    valueRange = neighborhoodRangeSliderRange
                )
            }
            NeighborhoodTypeVisualisationSurface(
                modifier = Modifier.padding(start = 5.dp),
                neighborhoodTypeVisualisation = neighborhoodTypeVisualisation
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Column {
            val survivalRangeSlider = floatRangeFromIntegers(
                R.integer.min_survival_range,
                R.integer.max_survival_range
            )
            val reviveNeighborCountRange = floatRangeFromIntegers(
                R.integer.min_revival_range,
                R.integer.max_revival_range
            )
            TextView(
                text = stringResource(
                    R.string.cell_survives_when_it_has,
                    survivalRange.first,
                    survivalRange.last
                )
            )
            Slider(
                value = survivalRange.first.toFloat(),
                onValueChange = changeSurvivalRange,
                valueRange = survivalRangeSlider
            )
            TextView(
                text = stringResource(
                    R.string.cell_comes_to_life_when_it_has,
                    revivalNeighborCount
                )
            )
            Slider(
                value = revivalNeighborCount.toFloat(),
                onValueChange = changeRevivalNeighborCount,
                valueRange = reviveNeighborCountRange
            )
        }
    }
}

@Composable
private fun GameStats(
    modifier: Modifier = Modifier,
    gameStats: GameStats
) {
    Column(modifier = modifier) {
        TextView(text = stringResource(R.string.generation, gameStats.generation))
        TextView(text = stringResource(R.string.alive_cells, gameStats.aliveCells))
        TextView(text = stringResource(R.string.dead_cells, gameStats.deadCells))
        TextView(text = stringResource(R.string.oldest_cell, gameStats.oldestCell))
    }

}

@Composable
private fun Settings(
    modifier: Modifier = Modifier,
    cellClusterThickness: Int,
    changeCellClusterThickness: (Float) -> Unit,
    gameSpeed: Int,
    changeGameSpeed: (Float) -> Unit,
    cellSize: Float,
    changeCellSize: (Float) -> Unit,
) {
    val cellClusterThicknessRange = floatRangeFromIntegers(
        R.integer.min_cell_cluster_thickness,
        R.integer.max_cell_cluster_thickness
    )
    val gameSpeedRange = floatRangeFromIntegers(R.integer.min_game_speed, R.integer.max_game_speed)
    val cellSizeRange = floatRangeFromIntegers(R.integer.min_cell_size, R.integer.max_cell_size)
    Column(
        modifier = modifier
    ) {
        TextView(text = stringResource(R.string.cell_cluster_thickness))
        Slider(
            value = cellClusterThickness.toFloat(),
            onValueChange = changeCellClusterThickness,
            valueRange = cellClusterThicknessRange
        )
        TextView(text = stringResource(R.string.game_speed))
        Slider(
            value = gameSpeed.toFloat(),
            onValueChange = changeGameSpeed,
            valueRange = gameSpeedRange
        )
        TextView(text = stringResource(R.string.game_field_dimensions))
        Slider(
            value = cellSize,
            onValueChange = changeCellSize,
            valueRange = cellSizeRange
        )
    }
}

@Composable
private fun ControlButtons(
    modifier: Modifier = Modifier,
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onResetButtonClick: () -> Unit
) {
    Row(modifier = modifier) {
        TextButton(modifier = Modifier.weight(1f), onClick = onStartButtonClick) {
            Text(
                text = stringResource(R.string.start),
                fontSize = dimensionResource(R.dimen.control_buttons_font_size).value.sp,
                fontFamily = Font(R.font.roboto_medium).toFontFamily()
            )
        }
        TextButton(modifier = Modifier.weight(1f), onClick = onStopButtonClick) {
            Text(
                text = stringResource(R.string.stop),
                fontSize = dimensionResource(R.dimen.control_buttons_font_size).value.sp,
                fontFamily = Font(R.font.roboto_medium).toFontFamily()
            )
        }
        TextButton(modifier = Modifier.weight(1f), onClick = onResetButtonClick) {
            Text(
                text = stringResource(R.string.rest),
                fontSize = dimensionResource(R.dimen.control_buttons_font_size).value.sp,
                fontFamily = Font(R.font.roboto_medium).toFontFamily()
            )
        }
    }
}


@Composable
private fun <T> DropDownMenu(
    modifier: Modifier = Modifier,
    selectedItem: T,
    items: List<T>,
    onItemClick: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        TextButton(onClick = { expanded = !expanded }) {
            Text(
                text = selectedItem.toString(),
                fontSize = dimensionResource(R.dimen.drop_down_menu_font_size).value.sp,
                fontFamily = Font(R.font.roboto_medium).toFontFamily()
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded }
        ) {
            for (item in items) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item.toString(),
                            fontSize = dimensionResource(R.dimen.drop_down_menu_font_size).value.sp,
                            fontFamily = Font(R.font.roboto_medium).toFontFamily()
                        )
                    },
                    onClick = {
                        onItemClick.invoke(item)
                        expanded = !expanded
                    }
                )
            }
        }
    }
}

@Composable
private fun Container(
    modifier: Modifier = Modifier,
    label: String,
    content: @Composable () -> Unit
) {
    Surface(modifier = modifier.padding(bottom = 10.dp)) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(
                modifier = Modifier.padding(top = 10.dp, end = 10.dp),
                text = label,
                fontFamily = Font(R.font.roboto_bold).toFontFamily(),
                fontSize = dimensionResource(R.dimen.label_font_size).value.sp
            )
            Line(strokeWidth = 3.dp)
            Spacer(modifier = Modifier.height(5.dp))
            content.invoke()
        }
    }
}

@Composable
private fun NeighborhoodTypeVisualisationSurface(
    modifier: Modifier = Modifier,
    neighborhoodTypeVisualisation: Array<Array<Cell>>
) {
    Canvas(
        modifier = modifier
            .size(100.dp)
            .border(2.dp, Color.Black),
        onDraw = {
            drawRect(
                color = Color.White,
                topLeft = Offset(0f, 0f),
                size = Size(size.width, size.height)
            )

            val cellSize = ((size.width + size.height) / 100) * 2f

            val matrixSize = neighborhoodTypeVisualisation.size
            val matrixCenter = matrixSize / 2

            for (y in 0 until matrixSize) {
                for (x in 0 until matrixSize) {
                    val cell = neighborhoodTypeVisualisation[y][x]
                    val color = if (cell.isAlive) Color.Black else Color.Transparent
                    drawRect(
                        color = color,
                        topLeft = Offset(
                            x = (center.x + matrixCenter * cellSize) - x * cellSize,
                            y = (center.y + matrixCenter * cellSize) - y * cellSize
                        ),
                        size = Size(cellSize, cellSize),
                    )
                }
            }

        }
    )
}

@Composable
fun TextView(
    modifier: Modifier = Modifier,
    text: String
) {
    Text(
        modifier = modifier,
        text = text,
        fontFamily = Font(R.font.roboto_regular).toFontFamily(),
        fontSize = dimensionResource(R.dimen.default_font_size).value.sp
    )
}

@Composable
private fun floatRangeFromIntegers(
    @IntegerRes from: Int,
    @IntegerRes to: Int
): ClosedFloatingPointRange<Float> {
    return integerResource(from).toFloat().rangeTo(integerResource(to).toFloat())
}

@Composable
@Preview
private fun Preview() {
    GameOfLifeTheme {
        DrawerContent(
            gameStats = GameStats(),
            gameRules = GameRules(NeighborhoodType.VON_NEUMANN, 0, 2..3, 0),
            gameSettings = GameSettings(1, 1, 1f),
            neighborhoodTypeVisualisation = Array(12) { Array(12) { Cell(false, 0) } },
            changeNeighborhoodRange = {},
            changeNeighborhoodType = {},
            changeCellSize = {},
            changeGameSpeed = {},
            changeCellClusterThickness = {},
            changeRevivalNeighborCount = {},
            changeSurvivalRange = {},
            onResetButtonClick = {},
            onStopButtonClick = {},
            onStartButtonClick = {}
        )
    }
}