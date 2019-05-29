package com.emami.android.comicworld

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import ss.com.bannerslider.Slider


@BindingAdapter("app:clip_slider")
fun clipImageViewCorners(view: Slider, enabled: Boolean) {
    if (enabled) {
        view.outlineProvider = object : ViewOutlineProvider() {

            override fun getOutline(view: View?, outline: Outline?) {
                outline?.setRoundRect(0, 0, (view!!.width + 90f).toInt(), view.height, 100f)
            }
        }
        view.clipToOutline = true
    }
}
