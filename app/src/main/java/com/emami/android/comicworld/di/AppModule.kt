package com.emami.android.comicworld.di

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideConnectivityManager(app: Application): ConnectivityManager= app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}