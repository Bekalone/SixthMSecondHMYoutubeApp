package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.sixthmsecondhmyoutubeapp.R
import com.example.sixthmsecondhmyoutubeapp.databinding.FragmentPlaylistBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.App
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseFragment
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {


    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {

        var data = App.db.dao().getPlaylist()
        viewModel.playlist.observe(viewLifecycleOwner) {
            viewModel.progress.value = it.status == Resource.Status.LOADING
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Log.d("ololo", "initView: ${it.data}")
                    it.data?.let { it1 -> App.db.dao().insert(it1) }
                }
                Resource.Status.ERROR -> {
                    Log.d("ololo", "initView: ${it.message}")
                }
            }
        }

        viewModel.progress.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }
    }

    override fun initListener() {

    }
}