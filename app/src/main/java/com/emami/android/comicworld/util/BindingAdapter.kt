package com.emami.android.comicworld.util

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.databinding.BindingAdapter
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

@BindingAdapter("imgSrc")
fun ImageView.loadImagesFromPicasso(imgSrc: String) {
    Picasso.get().load(imgSrc).into(this)
}
//
//
//@BindingAdapter("recyclerList")
//fun RecyclerView.setData(data: List<ComicPreview>?) {
//    val adapter = this.adapter as ExploreListAdapter
//    adapter.submitList(data)
//}
