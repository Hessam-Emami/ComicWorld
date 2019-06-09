package com.emami.android.comicworld.ui.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.ui.chapter.ChapterFragment
import com.emami.android.comicworld.ui.detail.DetailFragment

class ComicFragmentPager(val comicDTO: ComicDTO, fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return DetailFragment.newInstance(comicDTO)
        }
        else {
            return ChapterFragment.newInstance()
        }

    }
    override fun getCount() = 2


    override fun getPageTitle(position: Int) = when(position){
        0 -> "Detail"
        1 -> "chapters"
        else -> "Detail"
    }


}