package com.emami.android.comicworld.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.emami.android.comicworld.data.NetworkComic
import com.emami.android.comicworld.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(comic: NetworkComic): DetailFragment{
            val bundle = Bundle()
            bundle.putParcelable("comic", comic)
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    //TODO Completely add NetworkComic class and refactor it's vals!!
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val comic = DetailFragmentArgs.fromBundle(arguments!!).comic

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.comic = comic


        return binding.root
    }



}
