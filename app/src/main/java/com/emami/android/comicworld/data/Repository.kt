package com.emami.android.comicworld.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*

class Repository {
    private val database = FirebaseDatabase.getInstance()

    val banners = MutableLiveData<List<String>>()
    val comics = MutableLiveData<List<Comic>>()
    lateinit var lis : List<NetworkComic>

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
               val list= p0.children.map { it.getValue(NetworkComic::class.java) }
                    .map { it!!.asComic() }
                lis = p0.children.map { it.getValue(NetworkComic::class.java)!! }
                comics.value = list
            }

        })
    }
}