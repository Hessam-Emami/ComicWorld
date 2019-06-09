package com.emami.android.comicworld.di

import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.ui.explore.ExploreViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExploreViewModel::class)
    internal abstract fun bindExploreViewModel(exploreViewModel: ExploreViewModel): ViewModel
}