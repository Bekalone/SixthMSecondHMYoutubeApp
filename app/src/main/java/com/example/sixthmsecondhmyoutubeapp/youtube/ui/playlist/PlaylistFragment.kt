package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.sixthmsecondhmyoutubeapp.R
import com.example.sixthmsecondhmyoutubeapp.databinding.FragmentPlaylistBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.App
import com.example.sixthmsecondhmyoutubeapp.youtube.base.BaseFragment
import com.example.sixthmsecondhmyoutubeapp.youtube.data.domain.Resource
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

class PlaylistFragment : BaseFragment<FragmentPlaylistBinding, PlaylistViewModel>() {

    private lateinit var adapter: PlaylistAdapter

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findNavController().navigate(R.id.splashScreenFragment)
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentPlaylistBinding {
        return FragmentPlaylistBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        viewModel.getPlaylist()
        viewModel.playlist.observe(viewLifecycleOwner) {
            viewModel.progress.value = it.status == Resource.Status.LOADING
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    it.data?.let { it1 -> viewModel.setPlaylist(it1) }
                }
                Resource.Status.ERROR -> {

                }
            }
        }
        viewModel.localPlaylist.observe(viewLifecycleOwner){
            if (it.status == Resource.Status.SUCCESS){
                adapter = it.data?.let { it1 -> PlaylistAdapter(it1) }!!
                 binding.recyclerview.adapter = adapter
            }
        }

        viewModel.progress.observe(viewLifecycleOwner) {
            binding.progress.isVisible = it
        }
        viewModel.setPlaylist.observe(viewLifecycleOwner) {
            if (it.status == Resource.Status.SUCCESS && it.data == true) {
                viewModel.getLocalPlaylist()
            }

        }
    }

    override fun initListener() {

    }
}