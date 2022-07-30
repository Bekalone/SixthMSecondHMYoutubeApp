package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import androidx.lifecycle.LiveData
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseViewModel
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.data.newtwork.remote.repo.Repository
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

class PlaylistViewModel : BaseViewModel() {

    private val repo = Repository()

    val playlist: LiveData<Resource<Playlist?>> = repo.getPlaylist()

}