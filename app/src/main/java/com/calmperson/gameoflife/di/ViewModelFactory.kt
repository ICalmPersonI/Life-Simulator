package com.calmperson.gameoflife.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.calmperson.gameoflife.ui.viewmodel.UiModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<UiModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        UiModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}