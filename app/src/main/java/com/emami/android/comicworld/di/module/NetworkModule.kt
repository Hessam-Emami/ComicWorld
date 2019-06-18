package com.emami.android.comicworld.di.module

import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    fun provideGson() = Gson()

    @Provides
    @JvmStatic
    @Singleton
    fun provideFirebase() = FirebaseDatabase.getInstance()

    @Provides
    @JvmStatic
    @Named("BannerRef")
    fun provideBannerRef(db: FirebaseDatabase) = db.getReference("banner")

    @Provides
    @JvmStatic
    @Named("ComicRef")

    fun provideComicRef(db: FirebaseDatabase) = db.getReference("comic")
}