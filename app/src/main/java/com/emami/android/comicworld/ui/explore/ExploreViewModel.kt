package com.emami.android.comicworld.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.data.ComicPreview
import com.emami.android.comicworld.data.Repository
import com.emami.android.comicworld.data.network.ComicDataState
import timber.log.Timber
import javax.inject.Inject

class ExploreViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    init {
        Timber.d("I got created!")
    }

    private val _bannerList = MutableLiveData<List<String>>()
    val bannerList: LiveData<List<String>>
        get() = _bannerList

    private val _comicViewState = MutableLiveData<ComicViewState>()
    val comicList: LiveData<ComicViewState>
        get() = _comicViewState

    private val _navigateToSelectedComic = MutableLiveData<ComicDTO>()
    val navigateToSelectedComicDTO: LiveData<ComicDTO>
        get() = _navigateToSelectedComic

    init {
        test()
    }

    fun test() {
        repository.requestComicData { state ->
            _comicViewState.value = when (state) {
                ComicDataState.Loading -> ComicViewState.InProgress
                is ComicDataState.Error -> ComicViewState.ShowError(state.message)
                is ComicDataState.Success<*> -> ComicViewState.ShowComics(state.data as List<Comic>)
            }
        }
    }
     fun displayComicDetails(comicPreview: ComicPreview){
//         val name = comicPreview.name
//         val com = repository.lis.find { it.name == name }
//         Log.d("COMIC", com.toString())
//        _navigateToSelectedComic.value = com!!
    }

     fun displayComicDetailsCompleted(){
        _navigateToSelectedComic.value = null
    }
}

sealed class ComicViewState {

    object InProgress : ComicViewState()

    class ShowComics(val comics: List<Comic>) : ComicViewState()

    class ShowError(val message: String) : ComicViewState()
}