package com.romesh.dagger_mvvm_room_coroutine.di.component

import android.app.Application
import com.romesh.dagger_mvvm_room_coroutine.DaggerMVVMMultiBindingApplication
import com.romesh.dagger_mvvm_room_coroutine.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class,
        AppModule::class, ApiModule::class, DatabaseModule::class, ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<DaggerMVVMMultiBindingApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance // you'll call this when setting up Dagger
        fun baseUrl(@Named("baseUrl") baseUrl: String): Builder

        fun build(): AppComponent
    }

}