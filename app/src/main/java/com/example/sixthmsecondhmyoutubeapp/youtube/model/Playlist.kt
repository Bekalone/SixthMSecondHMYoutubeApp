package com.example.sixthmsecondhmyoutubeapp.youtube.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Playlist(
    @PrimaryKey(autoGenerate = true)
    var id: Int?
    ,
    var kind: String?,
)
