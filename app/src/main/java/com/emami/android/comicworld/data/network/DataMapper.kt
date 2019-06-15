package com.emami.android.comicworld.data.network

interface DataMapper<S, R> {
    fun map(source: S): R

}