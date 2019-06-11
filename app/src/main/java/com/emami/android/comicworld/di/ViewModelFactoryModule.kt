package com.emami.android.comicworld.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emami.android.daggertest.viewModel.ViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import javax.inject.Scope
import kotlin.reflect.KClass


@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)

