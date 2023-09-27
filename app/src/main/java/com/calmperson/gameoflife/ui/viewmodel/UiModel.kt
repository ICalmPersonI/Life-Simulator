package com.calmperson.gameoflife.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calmperson.gameoflife.domain.GameEngine
import com.calmperson.gameoflife.model.ScreenSize
import com.calmperson.gameoflife.ui.handler.DrawerContentHandler
import com.calmperson.gameoflife.ui.handler.GameFieldHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class UiModel @Inject constructor(private val gameEngine: GameEngine) : ViewModel() {

    private val screenSize = ScreenSize(0, 0)

    val gameFieldHandler = GameFieldHandler(gameEngine)
    val drawerContentHandler = DrawerContentHandler(gameEngine, screenSize)

    fun setScreenSize(screenHeight: Int, screenWidth: Int) {
        screenSize.height = screenHeight
        screenSize.width = screenWidth
    }

    fun saveAppData() = with(gameEngine) {
        viewModelScope.launch(Dispatchers.IO) {
            saveGameField()
            saveGameStats()
            saveGameRules()
            saveSettings()
        }
    }

    fun loadAppData() = with(gameEngine) {
        viewModelScope.launch(Dispatchers.IO) {
            loadGameField(screenSize)
            loadGameStats()
            loadGameRules()
            loadGameSettings()
        }
    }

}