package com.emami.android.comicworld.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Banner(val src: String)

@Parcelize
data class Comic(val name:String, val imgSource: String) : Parcelable