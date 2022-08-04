package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo.Repository
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

class PlaylistViewModel : BaseViewModel() {

    private val repo = Repository()

    private val _playlist = MutableLiveData<Playlist>()
    private val _result = MutableLiveData<Boolean>()
    private val _local = MutableLiveData<Boolean>()

    val setPlaylist = _playlist.switchMap {
        repo.setPlaylist(it)
    }

    val playlist = _result.switchMap {
        repo.getPlaylist()
    }

    val localPlaylist = _local.switchMap {
        repo.getLocalPlaylist()
    }

    fun getPlaylist(){
        _result.value = true
    }

    fun getLocalPlaylist(){
        _local.value = true
    }

    fun setPlaylist(playlist: Playlist) {
        _playlist.value = playlist
    }
}