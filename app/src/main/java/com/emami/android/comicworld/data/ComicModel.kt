package com.emami.android.comicworld.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ComicDTO(val name: String? = "",
                    val image: String? = "",
                    val category: String? = "",
                    val year: String? = "",
                    val description: String? = "",
                    val chapters: List<Chapter>? = null) : Parcelable

@Parcelize
data class ComicPreview(val name:String, val imgSource: String) : Parcelable

@Parcelize
data class Chapter(val links: List<String>? = listOf(),
                   val name: String? = "") : Parcelable

fun ComicDTO.asComic(): ComicPreview{
    return ComicPreview(name = this.name!!, imgSource = this.image!!)
}
