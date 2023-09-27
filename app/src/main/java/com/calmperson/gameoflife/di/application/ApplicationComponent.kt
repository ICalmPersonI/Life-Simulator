package com.calmperson.gameoflife.di.application

import android.content.Context
import com.calmperson.gameoflife.di.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun viewModelFactory(): ViewModelFactory

}