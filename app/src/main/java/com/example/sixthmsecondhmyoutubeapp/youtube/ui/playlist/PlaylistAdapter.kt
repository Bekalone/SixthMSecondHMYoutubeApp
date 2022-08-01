package com.example.sixthmsecondhmyoutubeapp.youtube.ui.playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sixthmsecondhmyoutubeapp.databinding.ItemPlaylistBinding
import com.example.sixthmsecondhmyoutubeapp.youtube.model.Playlist

class PlaylistAdapter(private var data: ArrayList<Playlist>) : RecyclerView.Adapter<PlaylistAdapter.PlaylistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(playlist: Playlist) {
            binding.image.load(playlist.snippet.thumbnails.url)
            binding.textview.text = playlist.snippet.title
        }
    }
}