package com.emami.android.comicworld

import com.emami.android.comicworld.di.DaggerAppComponent
import dagger.android.support.DaggerApplication
import timber.log.Timber

class ComicApp : DaggerApplication() {
    override fun applicationInjector() =
        DaggerAppComponent.builder().application(this).build()
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}