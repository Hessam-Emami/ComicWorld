package com.emami.android.comicworld.di

import com.emami.android.comicworld.ui.MainActivity
import com.emami.android.comicworld.ui.explore.ExploreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun contributeExploreFragment(): ExploreFragment


}