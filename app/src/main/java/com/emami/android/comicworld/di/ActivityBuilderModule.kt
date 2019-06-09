package com.emami.android.comicworld.di

import com.emami.android.comicworld.ui.MainActivity
import com.emami.android.comicworld.ui.explore.ExploreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeExploreFragment(): ExploreFragment

}