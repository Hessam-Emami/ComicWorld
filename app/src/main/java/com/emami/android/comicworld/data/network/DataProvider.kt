package com.emami.android.comicworld.data.network

interface DataProvider<T> {
    fun requestComicData(callback: (state: ComicDataState) -> Unit)
    fun requestBannerData(callback: (state: ComicDataState) -> Unit)
}