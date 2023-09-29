package com.calmperson.gameoflife.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.calmperson.gameoflife.di.application.GameApplication
import com.calmperson.gameoflife.ui.handler.DrawerContentHandler
import com.calmperson.gameoflife.ui.handler.GameFieldHandler
import com.calmperson.gameoflife.ui.screen.Root
import com.calmperson.gameoflife.ui.theme.GameOfLifeTheme
import com.calmperson.gameoflife.ui.viewmodel.UiModel
import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {

    val viewModel by viewModels<UiModel> {
        (applicationContext as GameApplication).appComponent.viewModelFactory()
    }

    private lateinit var gameFieldHandler: GameFieldHandler
    private lateinit var drawerContentHandler: DrawerContentHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameFieldHandler = viewModel.gameFieldHandler
        drawerContentHandler = viewModel.drawerContentHandler

        setContent {
            GameOfLifeTheme {
                Root(
                    gameField = gameFieldHandler.gameField,
                    isPaintingModeEnable = gameFieldHandler.isPaintingModeEnable,
                    gameStats = drawerContentHandler.gameStatistics,
                    gameRules = drawerContentHandler.gameRules,
                    gameSettings = drawerContentHandler.gameSettings,
                    neighborhoodTypeVisualisation = drawerContentHandler.neighborhoodTypeVisualisation,
                    changeCellSize = drawerContentHandler::changeCellSize,
                    changeCellClusterThickness = { thickness ->
                        drawerContentHandler.changeCellClusterThickness(
                            thickness.roundToInt()
                        )
                    },
                    changeGameSpeed = { speed -> drawerContentHandler.changeGameSpeed(speed.roundToInt()) },
                    changeNeighborhoodType = drawerContentHandler::changeNeighborhoodType,
                    changeNeighborhoodRange = { range ->
                        drawerContentHandler.changeNeighborhoodRange(
                            range.roundToInt()
                        )
                    },
                    changeSurvivalRange = { float ->
                        val intValue = float.toInt()
                        drawerContentHandler.changeSurvivalRange(intValue..intValue + 1)
                    },
                    changeRevivalNeighborCount = { float ->
                        drawerContentHandler.changeRevivalNeighborCount(
                            float.roundToInt()
                        )
                    },
                    onStartButtonClick = drawerContentHandler::startGame,
                    onStopButtonClick = drawerContentHandler::stopGame,
                    onResetButtonClick = drawerContentHandler::resetGame,
                    onGameFieldClick = gameFieldHandler::addCells,
                    onPencilButtonClick = {
                        with(gameFieldHandler) {
                            if (isPaintingModeEnable.value) {
                                disablePaintingMode()
                            } else {
                                enablePaintingMode()
                            }
                        }
                    }

                )
            }
        }
    }

    override fun onStart() {
        val displayMetrics = resources.displayMetrics
        viewModel.setScreenSize(displayMetrics.heightPixels, displayMetrics.widthPixels)
        super.onStart()
    }

    override fun onResume() {
        viewModel.loadAppData()
        super.onResume()
    }

    override fun onPause() {
        viewModel.saveAppData()
        super.onPause()
    }

}
