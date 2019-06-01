package com.emami.android.comicworld.ui.explore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.Comic
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ExploreViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val database = FirebaseDatabase.getInstance()

    private val _bannerList = MutableLiveData<List<String>>()
    val bannerList: LiveData<List<String>>
        get() = _bannerList

    private val _comicList = MutableLiveData<List<Comic>>()
    val comicList: LiveData<List<Comic>>
        get() = _comicList


    init {
        loadBanners()
        loadTrendingComics()
    }

    private fun loadBanners() {
        val ref = database.getReference("Banners")
        Log.d("MainActivity", "test")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("MainActivity", p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = p0.children.map { it.value.toString() }
                Log.d("MainActivity", list.size.toString())
                _bannerList.value = list
            }
        })
    }

    private fun loadTrendingComics() {
        val ref2 = database.getReference("Comic")
        ref2.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Log.d("MainActivity", p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list: List<Comic> = p0.children.map {
                    Comic(
                        it.child("Name").value as String,
                        it.child("Image").value as String
                    )
                }
                _comicList.value = list
            }

        })
    }

}
