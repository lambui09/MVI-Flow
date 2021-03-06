package com.lambui.framework.mvi.ui.main.viewstate

import com.lambui.framework.mvi.data.model.Category
import com.lambui.framework.mvi.data.model.User

sealed class MainState {

    object Idle : MainState()
    object Loading : MainState()
    data class Users(val user: List<User>) : MainState()
    data class Error(val error: String?) : MainState()

    data class Languages(val listVocabulary : List<Category>) : MainState()

}