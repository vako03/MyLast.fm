package com.benten.lastfmapp.presentation.genres

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.benten.lastfmapp.R
import com.benten.lastfmapp.databinding.LayoutItemGenreBinding

class GenresAdapter : RecyclerView.Adapter<GenresAdapter.GenresHolder>() {

    private val itemList = mutableListOf<GenreUIModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresHolder {
        return GenresHolder(
            LayoutItemGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: GenresHolder, position: Int) {
        holder.bind(itemList[position])

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class GenresHolder(private val binding: LayoutItemGenreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: GenreUIModel) {
            binding.tvGenre.text = genre.name
            binding.tvListeners.text =
                binding.root.context.getString(R.string.listeners_count, genre.listeners)
        }
    }

}