package com.emami.android.comicworld.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.emami.android.comicworld.databinding.FragmentExploreBinding
import com.emami.android.comicworld.service.PicassoImageService
import com.emami.android.comicworld.ui.explore.adapter.BannerSliderAdapter
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
import com.emami.android.comicworld.ui.explore.adapter.OnClickListener
import ss.com.bannerslider.Slider

class ExploreFragment : Fragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        Slider.init(PicassoImageService())
        val sliderView: Slider = binding.bannerSlider
        viewModel.bannerList.observe(this, Observer {
            sliderView.setAdapter(BannerSliderAdapter(it))
        })
        binding.newRecyclerView.adapter = ExploreListAdapter(OnClickListener {
            viewModel.displayComicDetails(it)
        })
        binding.secRecyclerView.adapter = ExploreListAdapter(OnClickListener {
            viewModel.displayComicDetails(it)
        })

        viewModel.navigateToSelectedComicDTO.observe(this, Observer {
            if (it != null) {
                findNavController().navigate(ExploreFragmentDirections.actionExploreFragmentToPagerFragment(it))
                viewModel.displayComicDetailsCompleted()
            }
            })

        return binding.root
    }


}
