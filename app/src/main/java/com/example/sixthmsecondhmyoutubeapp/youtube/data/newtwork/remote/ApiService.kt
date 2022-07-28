package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote

import com.example.sixthmsecondhmyoutubeapp.BuildConfig
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("playlists")
    fun getPlaylist(
        @Query("part") part:String,
        @Query("channelId") channelId:String,
        @Query("key") key:String = BuildConfig.API_KEY
    ) : Call<Playlist>

}