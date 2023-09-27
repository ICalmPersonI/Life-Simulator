package com.calmperson.gameoflife.di.application

import android.content.Context
import com.calmperson.gameoflife.data.local.DataManager
import com.calmperson.gameoflife.data.mapper.JsonMapper
import com.calmperson.gameoflife.domain.GameEngine
import com.calmperson.gameoflife.domain.GameManager
import dagger.Module
import dagger.Provides

@Module
object ApplicationModule {

    @Provides
    fun provideGameManager(): GameManager = GameManager()

    @Provides
    fun provideDataManager(
        applicationContext: Context
    ): DataManager = DataManager(applicationContext)

    @Provides
    fun provideGameEngine(
        gameManager: GameManager,
        dataManager: DataManager
    ): GameEngine = GameEngine(gameManager, dataManager)


}