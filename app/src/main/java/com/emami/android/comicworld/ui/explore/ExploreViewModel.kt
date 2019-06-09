package com.emami.android.comicworld.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.ComicPreview
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.data.Repository

class ExploreViewModel : ViewModel() {
    private val repository = Repository()

    val bannerList: LiveData<List<String>>
        get() = repository.banners

    val comicList: LiveData<List<ComicPreview>>
        get() = repository.comics

    private val _navigateToSelectedComic = MutableLiveData<ComicDTO>()
    val navigateToSelectedComicDTO: LiveData<ComicDTO>
        get() = _navigateToSelectedComic

    init {
        repository.refreshData()
    }

     fun displayComicDetails(comicPreview: ComicPreview){
         val name = comicPreview.name
         val com = repository.lis.find { it.name == name }
         Log.d("COMIC", com.toString())
        _navigateToSelectedComic.value = com!!
    }

     fun displayComicDetailsCompleted(){
        _navigateToSelectedComic.value = null
    }


}
