package com.emami.android.comicworld.data

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class Repository @Inject constructor(

    @param:Named("BannerRef")
    val bannerReference: DatabaseReference,

    @param:Named("ComicRef")
    val comicReference: DatabaseReference
) {
    val banners = MutableLiveData<List<String>>()
    val comics = MutableLiveData<List<ComicPreview>>()
    lateinit var lis : List<ComicDTO>

    fun refreshData(){
        Timber.d("I got called")
        loadBanners()
        loadTrendingComics()
    }

    private fun loadBanners() {
        bannerReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Timber.d(p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list = p0.children.map { it.value.toString() }
                Timber.d(list.size.toString())
                banners.value = list
            }
        })
    }

    private fun loadTrendingComics(){
        comicReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                Timber.d(p0.message)
            }

            override fun onDataChange(p0: DataSnapshot) {
                val list= p0.children.map { it.getValue(ComicDTO::class.java) }
                    .map { it!!.asComic() }
                lis = p0.children.map { it.getValue(ComicDTO::class.java)!! }
                comics.value = list
            }

        })
    }
}