package com.lambui.framework.mvi.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lambui.framework.mvi.data.repository.MainRepository
import com.lambui.framework.mvi.ui.main.intent.MainIntent
import com.lambui.framework.mvi.ui.main.viewstate.MainState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect as collect1

@ExperimentalCoroutinesApi
class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state: StateFlow<MainState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect1 {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                    is MainIntent.FetchWord -> getVocabulary()
                }
            }
        }
    }

    private fun fetchUser() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Users(repository.getUsers())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }

    private fun getVocabulary() {
        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Languages(repository.getVocabulary())
            } catch (ex: java.lang.Exception) {
                MainState.Error(ex.localizedMessage)
            }
        }
    }
}