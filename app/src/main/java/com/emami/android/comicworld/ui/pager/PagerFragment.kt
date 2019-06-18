package com.emami.android.comicworld.ui.pager


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.databinding.FragmentPagerBinding


class PagerFragment : Fragment() {

    lateinit var comic: Comic
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPagerBinding.inflate(inflater, container , false)
        // Inflate the layout for this fragment

        comic = PagerFragmentArgs.fromBundle(arguments!!).comic
//        binding.comicDTO = comicDTO
//        binding.comicViewPager.adapter = ComicFragmentPager(
//            comicDTO,
//            childFragmentManager,
//            binding.comicTabLayout.childCount
//        )
        binding.comicTabLayout.setupWithViewPager(binding.comicViewPager)
        return binding.root
    }


}
