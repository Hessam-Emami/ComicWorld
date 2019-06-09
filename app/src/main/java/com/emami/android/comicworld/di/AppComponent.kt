package com.emami.android.comicworld.di

import com.emami.android.comicworld.ComicApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class]
)
interface AppComponent : AndroidInjector<ComicApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ComicApp): Builder

        fun build(): AppComponent
    }
}
