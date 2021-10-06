package com.lambui.framework.mvi.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lambui.framework.mvi.data.api.ApiHelper
import com.lambui.framework.mvi.data.repository.MainRepository
import com.lambui.framework.mvi.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}