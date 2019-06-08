package com.emami.android.comicworld.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.data.NetworkComic
import com.emami.android.comicworld.data.Repository
import com.emami.android.comicworld.data.asComic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ExploreViewModel : ViewModel() {
    private val repository = Repository()

    val bannerList: LiveData<List<String>>
        get() = repository.banners

    val comicList: LiveData<List<Comic>>
        get() = repository.comics

    private val _navigateToSelectedComic = MutableLiveData<NetworkComic>()
    val navigateToSelectedComic: LiveData<NetworkComic>
        get() = _navigateToSelectedComic

    init {
        repository.refreshData()
    }

     fun displayComicDetails(comic: Comic){
         val name = comic.name
         val com = repository.lis.find { it.Name == name }
         Log.d("COMIC", com.toString())
        _navigateToSelectedComic.value = com!!
    }

     fun displayComicDetailsCompleted(){
        _navigateToSelectedComic.value = null
    }


}
