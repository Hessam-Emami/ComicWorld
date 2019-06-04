package com.emami.android.comicworld.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Repository {
    private val database = FirebaseDatabase.getInstance()

    val banners = MutableLiveData<List<String>>()
    val comics = MutableLiveData<List<Comic>>()

    fun refreshData(){
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
                banners.value = list
            }
        })
    }

    private fun loadTrendingComics(){
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
                comics.value = list
            }

        })
    }
}