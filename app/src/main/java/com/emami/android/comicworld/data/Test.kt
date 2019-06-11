package com.emami.android.comicworld.data

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class Test @Inject constructor() {
    val rand:Int
    get() = Random.nextInt()
}