package com.emami.android.comicworld.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.emami.android.comicworld.data.Comic

@Dao
interface ComicDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg comics: Comic)

    @Query("SELECT * FROM comic")
    fun getAll(): LiveData<List<Comic>>
}