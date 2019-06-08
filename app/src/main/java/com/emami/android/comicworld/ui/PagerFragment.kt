package com.emami.android.comicworld.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.emami.android.comicworld.data.NetworkComic
import com.emami.android.comicworld.databinding.FragmentPagerBinding
import com.emami.android.comicworld.ui.detail.ComicFragmentPager


class PagerFragment : Fragment() {

    lateinit var comic: NetworkComic
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPagerBinding.inflate(inflater, container , false)
        // Inflate the layout for this fragment

        comic = PagerFragmentArgs.fromBundle(arguments!!).comic
        binding.comic = comic
        binding.comicViewPager.adapter = ComicFragmentPager(comic,childFragmentManager,binding.comicTabLayout.childCount)
        binding.comicTabLayout.setupWithViewPager(binding.comicViewPager)
        return binding.root
    }


}
