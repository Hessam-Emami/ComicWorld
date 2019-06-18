package com.emami.android.comicworld.di.module

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

@Module
object RepositoryModule {


    @JvmStatic
    @Provides
    fun provideDataMapper(): DataMapper<DataSnapshot, List<Comic>> = ComicDataMapper()

    @JvmStatic
    @Provides
    fun provideComicDataProvider(
        connectivityChecker: ConnectivityChecker,
        comicDataMapper: DataMapper<DataSnapshot, List<Comic>>,
        @Named("BannerRef") bannerReference: DatabaseReference,
        @Named("ComicRef") comicReference: DatabaseReference
    ): ComicDataProvider = ComicDataProvider(connectivityChecker,
        comicDataMapper as ComicDataMapper, bannerReference, comicReference)
}