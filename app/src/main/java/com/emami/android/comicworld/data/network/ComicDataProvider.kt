package com.emami.android.comicworld.data.network

import com.emami.android.comicworld.util.ConnectivityChecker
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import timber.log.Timber

class ComicDataProvider constructor(
    val connectivityChecker: ConnectivityChecker,
    val comicDataMapper: ComicDataMapper,
    val bannerReference: DatabaseReference,
    val comicReference: DatabaseReference
) : DataProvider<ComicDataState> {


    override fun requestComicData(callback: (state: ComicDataState) -> Unit) {
        if (!connectivityChecker.isConnected) {
            callback(ComicDataState.Error("No Network Connectivity.."))
            Timber.d("No Network Connectivity..")
            return
        }
        callback(ComicDataState.Loading)
        Timber.d("Loading")
        val eventListener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Timber.d("Error %s", p0.message)
                callback(ComicDataState.Error(p0.message))
            }

            override fun onDataChange(p0: DataSnapshot) {
                val result = comicDataMapper.map(p0)
                callback(ComicDataState.Success(result))
                Timber.d("SUCCESS: %s", result.toString())
            }
        }
        comicReference.addListenerForSingleValueEvent(eventListener)

    }

    override fun requestBannerData(callback: (state: ComicDataState) -> Unit) {
        if (!connectivityChecker.isConnected) {
            callback(ComicDataState.Error("No Network Connectivity.."))
            return
        }
        val eventListener = object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Timber.d("Error %s", p0.message)
                callback(ComicDataState.Error(p0.message))
            }

            override fun onDataChange(p0: DataSnapshot) {
                val result = p0.children.map { it.value.toString() }
                callback(ComicDataState.Success(result))
                Timber.d("SUCCESS: %s", result.toString())

            }
        }
        callback(ComicDataState.Loading)
        bannerReference.addListenerForSingleValueEvent(eventListener)
    }


}


interface DataProvider<T> {
    fun requestComicData(callback: (state: ComicDataState) -> Unit)
    fun requestBannerData(callback: (state: ComicDataState) -> Unit)
}