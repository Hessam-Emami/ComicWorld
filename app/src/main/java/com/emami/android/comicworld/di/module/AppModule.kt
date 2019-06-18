package com.emami.android.comicworld.di.module

import android.content.Context
import android.net.ConnectivityManager
import com.emami.android.comicworld.ComicApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//TODO SIMPLIFY DEPENDENCIES!!!!AND INJECTIONS!!!!
@Module
object AppModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideConnectivityManager(app: ComicApp): ConnectivityManager =
        app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}