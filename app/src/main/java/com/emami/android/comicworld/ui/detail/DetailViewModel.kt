package com.emami.android.comicworld.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emami.android.comicworld.data.Chapter

class DetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _navigateToChapters = MutableLiveData<List<Chapter>>()
    val navigateToChapters : LiveData<List<Chapter>>
        get() = _navigateToChapters

    fun displayChapters(chapter: List<Chapter>){
        _navigateToChapters.value = chapter
    }

    fun disp(){
        Log.d("TEST", "TEST: test");
    }
}
