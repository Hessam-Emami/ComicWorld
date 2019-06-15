package com.emami.android.comicworld.util

import android.net.ConnectivityManager
import javax.inject.Inject
import javax.inject.Singleton

class ConnectivityCheker @Inject constructor(val cm:ConnectivityManager){
    val isConnected: Boolean
        get() = cm.activeNetworkInfo?.isConnected ?: false
}