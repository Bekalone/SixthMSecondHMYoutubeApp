package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.RetrofitClient
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist
import com.example.sixthmsecondhmyoutubeapp.youtube.utils.Const
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylist(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        apiService.getPlaylist(Const.PART, Const.CHANNEL_ID).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                print(t.message)
            }
        })
        return data
    }
}