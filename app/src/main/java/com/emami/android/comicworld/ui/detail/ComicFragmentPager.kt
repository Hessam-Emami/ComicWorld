package com.emami.android.comicworld.ui.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.emami.android.comicworld.data.NetworkComic
import com.emami.android.comicworld.ui.chapter.ChapterFragment

class ComicFragmentPager(val comic: NetworkComic,fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return DetailFragment.newInstance(comic)
        }
        else {
            return ChapterFragment.newInstance()
        }

    }
    override fun getCount() = 2


    override fun getPageTitle(position: Int) = when(position){
        0 -> "Detail"
        1 -> "Chapters"
        else -> "Detail"
    }


}