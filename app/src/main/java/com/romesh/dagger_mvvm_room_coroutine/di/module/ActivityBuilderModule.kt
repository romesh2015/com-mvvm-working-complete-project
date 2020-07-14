package com.romesh.dagger_mvvm_room_coroutine.di.module

import com.romesh.dagger_mvvm_room_coroutine.activity.main.MainActivity
import com.romesh.dagger_mvvm_room_coroutine.activity.main.UserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributesInjectMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributesInjectUserActivity(): UserActivity

}