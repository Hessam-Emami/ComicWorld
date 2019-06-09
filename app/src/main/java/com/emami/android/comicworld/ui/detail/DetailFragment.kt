package com.emami.android.comicworld.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    companion object {
        fun newInstance(comicDTO: ComicDTO): DetailFragment{
            val bundle = Bundle()
            bundle.putParcelable("comicDTO", comicDTO)
            val fragment = DetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    //TODO Completely add ComicDTO class and refactor it's vals!!
    private lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        val comic = DetailFragmentArgs.fromBundle(arguments!!).comicDTO

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.comicDTO = comic


        return binding.root
    }



}
