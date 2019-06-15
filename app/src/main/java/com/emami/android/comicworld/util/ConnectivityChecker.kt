package com.emami.android.comicworld.util

import android.net.ConnectivityManager
import javax.inject.Inject

class ConnectivityChecker @Inject constructor(val cm: ConnectivityManager) {
    val isConnected: Boolean
        get() = cm.activeNetworkInfo?.isConnected ?: false
}