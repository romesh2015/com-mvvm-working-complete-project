package com.romesh.dagger_mvvm_room_coroutine.di.module

import androidx.lifecycle.ViewModel
import com.romesh.dagger_mvvm_room_coroutine.activity.main.MainActivityViewModel
import com.romesh.dagger_mvvm_room_coroutine.di.annotation.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(
        MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel
}