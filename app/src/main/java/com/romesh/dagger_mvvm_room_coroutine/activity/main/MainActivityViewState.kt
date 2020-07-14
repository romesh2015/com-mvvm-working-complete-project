package com.romesh.dagger_mvvm_room_coroutine.activity.main

import com.romesh.dagger_mvvm_room_coroutine.Users

sealed class MainActivityViewState {
    object ShowLoading : MainActivityViewState()
    class ShowError(val error: Throwable) : MainActivityViewState()
    //class ShowData(val data: List<Users>) : MainActivityViewState()
}