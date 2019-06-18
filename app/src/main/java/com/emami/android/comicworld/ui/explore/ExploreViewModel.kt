package com.emami.android.comicworld.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.data.Repository
import com.emami.android.comicworld.data.network.ComicDataState
import timber.log.Timber
import javax.inject.Inject

class ExploreViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    init {
        Timber.d("I got created!")
        Timber.d("Repo Id: $repository")
        load()
    }

    private val _comicViewState = MutableLiveData<DataViewState>()
    val comicViewState: LiveData<DataViewState>
        get() = _comicViewState

    private val _bannerViewState = MutableLiveData<DataViewState>()
    val bannerViewState: LiveData<DataViewState>
        get() = _bannerViewState

    private val _navigateToSelectedComic = MutableLiveData<ComicDTO>()
    val navigateToSelectedComicDTO: LiveData<ComicDTO>
        get() = _navigateToSelectedComic


    private fun load() {
        repository.requestComicData { state ->
            _comicViewState.value = when (state) {
                ComicDataState.Loading -> DataViewState.InProgress
                is ComicDataState.Error -> DataViewState.ShowError(state.message)
                is ComicDataState.Success<*> -> DataViewState.ShowComics(state.data)
            }
        }

        repository.requestBannerData { state ->
            _bannerViewState.value = when (state) {
                ComicDataState.Loading -> DataViewState.InProgress
                is ComicDataState.Error -> DataViewState.ShowError(state.message)
                is ComicDataState.Success<*> -> DataViewState.ShowComics(state.data)
            }
        }
    }
//     fun displayComicDetails(comicPreview: ComicPreview){
////         val name = comicPreview.name
////         val com = repository.lis.find { it.name == name }
////         Log.d("COMIC", com.toString())
////        _navigateToSelectedComic.value = com!!
//    }

     fun displayComicDetailsCompleted(){
        _navigateToSelectedComic.value = null
    }


}

sealed class DataViewState {

    object InProgress : DataViewState()

    class ShowComics<T>(val data: T) : DataViewState()

    class ShowError(val message: String) : DataViewState()
}