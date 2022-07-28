package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.sixthmsecondhmyoutubeapp.R
import com.example.sixthmsecondhmyoutubeapp.databinding.FragmentPlaylistBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseFragment

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
        viewModel.getPlaylist().observe(viewLifecycleOwner) {

        }
    }

    override fun initListener() {

    }
}