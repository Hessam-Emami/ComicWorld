package com.emami.android.comicworld.di

import android.app.Application
import androidx.room.Room
import com.emami.android.comicworld.data.local.ComicDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Singleton
    @JvmStatic
    @Provides
    fun provideRoomDatabase(application: Application) = Room.databaseBuilder(application,
        ComicDatabase::class.java,"comic_database").build()

    @Singleton
    @JvmStatic
    @Provides
    fun provideDatabaseService(database: ComicDatabase) = database.comicDao()
}