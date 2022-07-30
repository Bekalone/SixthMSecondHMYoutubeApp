package com.example.sixthmsecondhmyoutubeapp.youtube.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

@Dao
interface Dao {

    @Insert
    fun insert(playlist: Playlist)

    @Insert
    fun insertAll(playlist: List<Playlist>)

    @Query("SELECT * FROM playlist")
    fun getPlaylist(): List<Playlist>
}