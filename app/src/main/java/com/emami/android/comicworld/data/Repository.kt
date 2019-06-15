package com.emami.android.comicworld.data

import com.emami.android.comicworld.data.network.ComicDataProvider
import com.emami.android.comicworld.data.network.ComicDataState
import com.emami.android.comicworld.data.network.DataProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(

    val dataProvider: ComicDataProvider
) : DataProvider<ComicDataState> {
    override fun requestBannerData(callback: (state: ComicDataState) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun requestComicData(callback: (state: ComicDataState) -> Unit) {
        dataProvider.requestComicData { state -> callback(state) }
    }


}