package com.emami.android.comicworld.di

import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.data.network.ComicDataMapper
import com.emami.android.comicworld.data.network.ComicDataProvider
import com.emami.android.comicworld.data.network.DataMapper
import com.emami.android.comicworld.util.ConnectivityChecker
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object RepositoryModule {


    @JvmStatic
    @Provides
    @Singleton
    fun provideDataMapper(): DataMapper<DataSnapshot, List<Comic>> = ComicDataMapper()

    @JvmStatic
    @Provides
    @Singleton
    fun provideComicDataProvider(
        connectivityChecker: ConnectivityChecker,
        comicDataMapper: ComicDataMapper,
        @Named("BannerRef") bannerReference: DatabaseReference,
        @Named("ComicRef") comicReference: DatabaseReference
    ): ComicDataProvider = ComicDataProvider(connectivityChecker, comicDataMapper, bannerReference, comicReference)
}