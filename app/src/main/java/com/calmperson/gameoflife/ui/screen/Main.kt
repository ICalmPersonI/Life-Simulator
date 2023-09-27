package com.calmperson.gameoflife.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.calmperson.gameoflife.R
import com.calmperson.gameoflife.ui.component.GameField
import com.calmperson.gameoflife.model.Cell
import com.calmperson.gameoflife.model.GameRules
import com.calmperson.gameoflife.model.GameSettings
import com.calmperson.gameoflife.model.GameStats
import com.calmperson.gameoflife.model.NeighborhoodType
import com.calmperson.gameoflife.ui.component.DrawerContent

import kotlinx.coroutines.flow.StateFlow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Root(
    gameField: StateFlow<Array<Array<Cell>>?>,
    isPaintingModeEnable: StateFlow<Boolean>,
    gameStats: StateFlow<GameStats>,
    gameRules: StateFlow<GameRules>,
    gameSettings: StateFlow<GameSettings>,
    neighborhoodTypeVisualisation: StateFlow<Array<Array<Cell>>>,
    changeGameSpeed: (Float) -> Unit,
    changeCellSize: (Float) -> Unit,
    changeCellClusterThickness: (Float) -> Unit,
    changeNeighborhoodType: (NeighborhoodType) -> Unit,
    changeNeighborhoodRange: (Float) -> Unit,
    changeSurvivalRange: (Float) -> Unit,
    changeRevivalNeighborCount: (Float) -> Unit,
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onResetButtonClick: () -> Unit,
    onPencilButtonClick: () -> Unit,
    onGameFieldClick: (Int, Int) -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val isPaintingModeEnableState = isPaintingModeEnable.collectAsState()
    val gameStatsState = gameStats.collectAsState()
    val gameRulesState = gameRules.collectAsState()
    val gameSettingsState = gameSettings.collectAsState()
    val neighborhoodTypeVisualisationState = neighborhoodTypeVisualisation.collectAsState()

    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = Color.Transparent,
        drawerContent = {
            DrawerContent(
                modifier = Modifier.width(dimensionResource(R.dimen.drawer_content_width)),
                gameStats = gameStatsState.value,
                gameRules = gameRulesState.value,
                gameSettings = gameSettingsState.value,
                neighborhoodTypeVisualisation = neighborhoodTypeVisualisationState.value,
                changeCellSize = changeCellSize,
                changeGameSpeed = changeGameSpeed,
                changeCellClusterThickness = changeCellClusterThickness,
                changeNeighborhoodType = changeNeighborhoodType,
                changeNeighborhoodRange = changeNeighborhoodRange,
                changeSurvivalRange = changeSurvivalRange,
                changeRevivalNeighborCount = changeRevivalNeighborCount,
                onStartButtonClick = onStartButtonClick,
                onStopButtonClick = onStopButtonClick,
                onResetButtonClick = onResetButtonClick
            )
        }
    ) {
        Scaffold(
            modifier = Modifier,
            floatingActionButton = {
                val defaultColor = MaterialTheme.colorScheme.primary
                val pressedColor = Color.DarkGray
                FilledIconButton(
                    modifier = Modifier
                        .size(100.dp),
                    onClick = onPencilButtonClick,
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = if (isPaintingModeEnableState.value) pressedColor else defaultColor,
                        contentColor = if (isPaintingModeEnableState.value) Color.Black else Color.White
                    )
                ) {
                    Icon(
                        modifier = Modifier.padding(20.dp),
                        painter = painterResource(R.drawable.pencil),
                        contentDescription = null,
                    )
                }

            }
        ) { padding ->
            GameField(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize(),
                data = gameField,
                cellSize = gameSettingsState.value.cellSize,
                isPaintingModeEnable = isPaintingModeEnableState.value,
                onClick = onGameFieldClick
            )
        }
    }
}