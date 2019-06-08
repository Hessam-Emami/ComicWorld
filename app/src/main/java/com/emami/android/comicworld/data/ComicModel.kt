package com.emami.android.comicworld.data

import android.os.Parcelable
import com.google.firebase.database.PropertyName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Comic(val name:String, val imgSource: String) : Parcelable

@Parcelize
data class NetworkComic(val Name: String? = "",
                        val Image: String? = "",
                        val Category: String? = "",
                        val Description: String? = "",
                        val Chapters: List<Chapter>? = null) : Parcelable

@Parcelize
data class Chapter(val Links: List<String>? = listOf(),
                   val Name: String? = "") : Parcelable

fun NetworkComic.asComic(): Comic{
    return Comic(name = this.Name!!, imgSource = this.Image!!)
}