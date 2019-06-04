package com.emami.android.comicworld.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.data.Repository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ExploreViewModel : ViewModel() {
    private val repository = Repository()
     val t1 = repository.banners
     val t2 = repository.comics

    val bannerList: LiveData<List<String>>
        get() = repository.banners

    val comicList: LiveData<List<Comic>>
        get() = repository.comics

    private val _navigateToSelectedComic = MutableLiveData<Comic>()
    val navigateToSelectedComic: LiveData<Comic>
        get() = _navigateToSelectedComic

    init {
        repository.refreshData()
    }

     fun displayComicDetails(comic: Comic){
        _navigateToSelectedComic.value = comic
    }

     fun displayComicDetailsCompleted(){
        _navigateToSelectedComic.value = null
    }


}
