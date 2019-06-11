package com.emami.android.comicworld.di

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object NetworkModule {

    @Provides
    @JvmStatic
    @TestScope

    fun provideFirebase() = FirebaseDatabase.getInstance()

    @Provides
    @JvmStatic
    @TestScope

    @Named("BannerRef")

    fun provideBannerRef(db: FirebaseDatabase) = db.getReference("banner")

    @Provides
    @JvmStatic
    @TestScope
    @Named("ComicRef")

    fun provideComicRef(db: FirebaseDatabase) = db.getReference("comic")
}