package com.emami.android.comicworld

import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class BannerSliderAdapter(private val list:List<String>): SliderAdapter() {
    override fun getItemCount() = list.size

    override fun onBindImageSlide(position: Int, imageSlideViewHolder: ImageSlideViewHolder?) =
            imageSlideViewHolder!!.bindImageSlide(list[position])
}