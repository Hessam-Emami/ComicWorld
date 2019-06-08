package com.emami.android.comicworld.ui.chapter

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.emami.android.comicworld.R
import com.emami.android.comicworld.data.Chapter
import com.emami.android.comicworld.data.NetworkComic
import com.emami.android.comicworld.ui.detail.DetailFragment

class ChapterFragment : Fragment() {

    private lateinit var viewModel: ChapterViewModel

    companion object {
        fun newInstance(): ChapterFragment {
//            val bundle = Bundle()
//            bundle.putParcelableArray("chapter", chapter)
            val fragment = ChapterFragment()
//            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val chaps = ChapterFragmentArgs.fromBundle(arguments!!).chapter
//        Toast.makeText(this.context, chaps.toString(), Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_chapter, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChapterViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
