package com.emami.android.comicworld.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ComicDTO(val name: String? = "",
                    val image: String? = "",
                    val category: String? = "",
                    val year: String? = "",
                    val description: String? = "",
                    val chapters: List<Chapter>? = null) : Parcelable

@Entity
data class Comic(@PrimaryKey val name: String,
                 val image: String,
                 val category: String,
                 val year: String,
                 val description: String,
                 val chapters: List<Chapter>?)

fun Comic.asComicPreview(): ComicPreview{
    return ComicPreview(name = this.name, imgSource = this.image)
}
fun ComicDTO.asDBComic():Comic{ return Comic(this.name!!,this.image!!,
    this.category!!,this.year!!,this.description!!,this.chapters) }

@Parcelize
data class ComicPreview(val name:String, val imgSource: String) : Parcelable

@Parcelize
data class Chapter(val links: List<String>? = listOf(),
                   val name: String? = "") : Parcelable

fun ComicDTO.asComic(): ComicPreview{
    return ComicPreview(name = this.name!!, imgSource = this.image!!)
}
