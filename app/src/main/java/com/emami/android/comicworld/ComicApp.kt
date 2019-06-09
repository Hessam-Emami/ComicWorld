package com.emami.android.comicworld

import android.app.Application
import com.google.firebase.database.FirebaseDatabase
import timber.log.Timber

class ComicApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        Timber.plant(Timber.DebugTree())
    }
}