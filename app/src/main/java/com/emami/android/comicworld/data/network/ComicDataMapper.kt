package com.emami.android.comicworld.data.network

import com.emami.android.comicworld.data.Comic
import com.emami.android.comicworld.data.ComicDTO
import com.emami.android.comicworld.data.asDBComic
import com.google.firebase.database.DataSnapshot

class ComicDataMapper : DataMapper<DataSnapshot, List<Comic>> {
    override fun map(source: DataSnapshot): List<Comic> =
        source.children.map { it.getValue(ComicDTO::class.java) }.map {
            it!!.asDBComic()
        }


}