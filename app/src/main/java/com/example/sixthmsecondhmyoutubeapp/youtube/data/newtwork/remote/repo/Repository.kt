package com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.RetrofitClient
import com.example.sixthmsecondhmyoutubeapp.youtube.model.ErrorResponse
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject

class Repository {

    private val apiService = RetrofitClient.create()

    fun getPlaylist(): LiveData<Resource<Playlist?>> = liveData(Dispatchers.IO){
        val result = apiService.getPlaylist()
        emit(Resource.loading())
        if (result.isSuccessful){
            emit(Resource.success(result.body()))
        } else {
            val jObjError = result.errorBody()?.string()
            val gson = Gson()
            val data = gson.fromJson(jObjError,ErrorResponse::class.java)
            emit(Resource.error(data.error?.message.toString()))
        }
    }
}