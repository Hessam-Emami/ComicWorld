package com.emami.android.comicworld.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.databinding.FragmentExploreBinding
import com.emami.android.comicworld.service.PicassoImageService
import com.emami.android.comicworld.ui.explore.adapter.BannerSliderAdapter
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
import com.emami.android.comicworld.ui.explore.adapter.OnClickListener
import dagger.android.support.DaggerFragment
import ss.com.bannerslider.Slider
import javax.inject.Inject

class ExploreFragment : DaggerFragment() {
    private lateinit var binding: FragmentExploreBinding
    private lateinit var viewModel: ExploreViewModel
    @Inject lateinit var factory: ViewModelProvider.Factory

    private lateinit var exploreRecyclerAdapter: ExploreListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentExploreBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(ExploreViewModel::class.java)

        Slider.init(PicassoImageService())


        exploreRecyclerAdapter = ExploreListAdapter(OnClickListener { viewModel.displayComicDetailsCompleted() })
        binding.newRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.secRecyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.newRecyclerView.adapter = exploreRecyclerAdapter
        binding.secRecyclerView.adapter = exploreRecyclerAdapter
//
//        viewModel.comicViewState.observe(this, Observer {
//            when(it){
//                is DataViewState.InProgress -> showLoading()
//                is DataViewState.ShowError -> showError(it.message)
//                is DataViewState.ShowComics<*> -> showComicData(it.data)
//            }
//        })
//
//        viewModel.bannerViewState.observe(this, Observer {
//            when(it){
//                is DataViewState.InProgress -> showLoading()
//                is DataViewState.ShowError -> showError(it.message)
//                is DataViewState.ShowComics<*> -> showBannerData(it.data)
//            }
//        })



        viewModel.navigateToSelectedComic.observe(this, Observer {
            if (it != null) {
                findNavController().navigate(ExploreFragmentDirections.actionExploreFragmentToPagerFragment(it))
                viewModel.displayComicDetailsCompleted()
            }
            })

        return binding.root
    }

    private fun showComicData(data: Any?) {
        binding.progressBar.visibility = View.GONE
        exploreRecyclerAdapter.submitList(data as MutableList<Comic>?)
    }

    private fun showBannerData(data: Any?) {
        binding.bannerSlider.setAdapter(BannerSliderAdapter(data as List<String>))
        binding.progressBar.visibility = View.GONE
    }

    private fun showError(message: String) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this.context,message,Toast.LENGTH_LONG).show()

    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

}
