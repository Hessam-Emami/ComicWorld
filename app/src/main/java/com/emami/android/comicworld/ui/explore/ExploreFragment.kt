package com.emami.android.comicworld.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.emami.android.comicworld.databinding.FragmentExploreBinding
import com.emami.android.comicworld.service.PicassoImageService
import com.emami.android.comicworld.ui.explore.adapter.BannerSliderAdapter
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
import com.emami.android.comicworld.ui.explore.adapter.OnClickListener
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_explore.*
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

        viewModel = ViewModelProviders.of(this, factory).get(ExploreViewModel::class.java)
        binding = FragmentExploreBinding.inflate(inflater, container, false)

        Slider.init(PicassoImageService())
        exploreRecyclerAdapter = ExploreListAdapter(OnClickListener {  })

        viewModel.comicViewState.observe(this, Observer {
            when(it){
                is DataViewState.InProgress -> showLoading()
                is DataViewState.ShowError -> showError(it.message)
                is DataViewState.ShowComics<*> -> showComicData(it.data)
            }
        })

        viewModel.bannerViewState.observe(this, Observer {
            when(it){
                is DataViewState.InProgress -> showLoading()
                is DataViewState.ShowError -> showError(it.message)
                is DataViewState.ShowComics<*> -> showBannerData(it.data)
            }
        })



//        binding.newRecyclerView.adapter = ExploreListAdapter(OnClickListener {
//            viewModel.displayComicDetails(it)
//        })
//        binding.secRecyclerView.adapter = ExploreListAdapter(OnClickListener {
//            viewModel.displayComicDetails(it)
//        })
//
//        viewModel.navigateToSelectedComicDTO.observe(this, Observer {
//            if (it != null) {
//                findNavController().navigate(ExploreFragmentDirections.actionExploreFragmentToPagerFragment(it))
//                viewModel.displayComicDetailsCompleted()
//            }
//            })

        return binding.root
    }

    private fun showComicData(data: Any?) {
        binding.progressBar.visibility = View.GONE
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showBannerData(data: Any?) {
        binding.bannerSlider.setAdapter(BannerSliderAdapter(data as List<String>))
        binding.progressBar.visibility = View.GONE
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showError(message: String) {
        binding.progressBar.visibility = View.GONE
        Toast.makeText(this.context,message,Toast.LENGTH_LONG).show()

    }

    private fun showLoading(){
        binding.progressBar.visibility = View.VISIBLE
    }

}
