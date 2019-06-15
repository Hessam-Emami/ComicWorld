package com.emami.android.comicworld.data.network

sealed class ComicDataState {
    object Loading : ComicDataState()

    class Success<T>(val data: T) : ComicDataState()

    class Error(val message: String) : ComicDataState()
}