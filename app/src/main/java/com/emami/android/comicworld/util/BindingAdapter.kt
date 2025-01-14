package com.emami.android.comicworld.util

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.ui.explore.adapter.ExploreListAdapter
import com.squareup.picasso.Picasso
import ss.com.bannerslider.Slider


@BindingAdapter("app:clip_slider")
fun Slider.clipImageViewCorners(enabled: Boolean) {
    if (enabled) {
        this.outlineProvider = object : ViewOutlineProvider() {

            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, (view!!.width + 90f).toInt(), view.height, 100f)
            }
        }
        this.clipToOutline = true
    }
}

@BindingAdapter("bannerSrc")
fun ImageView.loadComicBanner(imgSrc: String) {
    Picasso.get().load(imgSrc).into(this)
}


@BindingAdapter("recyclerList")
fun RecyclerView.setData(data: List<Comic>?) {
    val adapter = this.adapter as ExploreListAdapter
    adapter.submitList(data)
}
