package com.emami.android.comicworld.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.emami.android.comicworld.data.Test
import com.emami.android.comicworld.databinding.FragmentExploreBinding
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
import com.emami.android.comicworld.ui.explore.adapter.OnClickListener
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class ExploreFragment : DaggerFragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    @Inject lateinit var test: Test

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("Ramd os "+test.toString())

        viewModel = ViewModelProviders.of(this, factory).get(ExploreViewModel::class.java)
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

//        Slider.init(PicassoImageService())
//        val sliderView: Slider = binding.bannerSlider
        viewModel.bannerList.observe(this, Observer {
            //            sliderView.setAdapter(BannerSliderAdapter(it))
            Timber.d(it.size.toString())
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
