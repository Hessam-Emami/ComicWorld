package com.emami.android.comicworld.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ComicDTO(val name: String? = "",
                    val image: String? = "",
                    val category: String? = "",
                    val year: String? = "",
                    val description: String? = "",
                    val chapters: List<Chapter>? = listOf()): Parcelable

@Parcelize
data class Comic(
    val name: String,
    val image: String,
    val category: String,
    val year: String,
    val description: String,
    val chapters: List<Chapter>): Parcelable


fun ComicDTO.asDBComic():Comic{ return Comic(this.name!!,this.image!!,
    this.category!!,this.year!!,this.description!!,this.chapters!!) }

@Parcelize
data class ComicPreview(val name:String, val imgSource: String) : Parcelable

@Parcelize
data class Chapter(val links: List<String>,
                   val name: String) : Parcelable


