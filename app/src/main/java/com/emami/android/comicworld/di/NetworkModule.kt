package com.emami.android.comicworld.di

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    @Singleton

    fun provideFirebase() = FirebaseDatabase.getInstance()

    @Provides
    @JvmStatic
    @Singleton

    @Named("BannerRef")

    fun provideBannerRef(db: FirebaseDatabase) = db.getReference("banner")

    @Provides
    @JvmStatic
    @Singleton
    @Named("ComicRef")

    fun provideComicRef(db: FirebaseDatabase) = db.getReference("comic")
}