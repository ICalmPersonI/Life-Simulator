package com.calmperson.gameoflife.di.application

import android.app.Application

class GameApplication : Application(), ApplicationComponentProvider {

    override val appComponent: ApplicationComponent by lazy {
        initComponent()
    }

    private fun initComponent(): ApplicationComponent {
        return DaggerApplicationComponent.factory().create(applicationContext)
    }




}