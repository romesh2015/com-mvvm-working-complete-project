package com.romesh.dagger_mvvm_room_coroutine

import com.romesh.dagger_mvvm_room_coroutine.di.component.DaggerAppComponent
import com.romesh.dagger_mvvm_room_coroutine.di.module.BaseURL
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class DaggerMVVMMultiBindingApplication : DaggerApplication() {


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).baseUrl(BaseURL.BASE_URL).build()

    }

}