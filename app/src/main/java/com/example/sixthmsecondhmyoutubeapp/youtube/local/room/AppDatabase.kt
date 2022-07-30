package com.example.sixthmsecondhmyoutubeapp.youtube.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

@Database(entities = [Playlist::class], version = 1)
abstract class AppDatabase :RoomDatabase() {

    abstract fun dao(): Dao
}