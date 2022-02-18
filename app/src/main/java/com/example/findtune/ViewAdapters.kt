package com.example.findtune

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.data.*
import com.example.findtune.models.*
import com.example.findtune.OnClickListener

class GenreCardAdapter (
    private val context: Context?,
    private val listener: (Genre) -> Unit
        ): RecyclerView.Adapter<GenreCardAdapter.GenreCardViewHolder>() {
    val genreList = Genres.genres

    class GenreCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!){
        val genreImage : ImageView = view!!.findViewById(R.id.genreImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreCardViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(R.layout.genre_list_item, parent, false)
        return GenreCardViewHolder(viewLayout)
    }

    override fun getItemCount(): Int = genreList.size

    override fun onBindViewHolder(holder: GenreCardViewHolder, position: Int) {
        val resources = context?.resources

        val genreItem = genreList[position]
        holder.genreImage.setImageResource((genreItem.imageResourceId))
        holder.itemView.setOnClickListener {
            listener(genreItem)
        }
    }
}

class ArtistCardAdapter (
    private val context: Context?,
    private val genre: Genre,
    private val listener: (Artist) -> Unit
): RecyclerView.Adapter<ArtistCardAdapter.ArtistCardViewHolder>() {
    val artistList = genre.topArtists

    class ArtistCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val genreImage: ImageView = view!!.findViewById(R.id.genreImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistCardViewHolder {
        val viewLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.genre_list_item, parent, false)
        return ArtistCardViewHolder(viewLayout)
    }

    override fun getItemCount(): Int = artistList.size

    override fun onBindViewHolder(holder: ArtistCardViewHolder, position: Int) {
        val resources = context?.resources

        val item = artistList[position]
        holder.genreImage.setImageResource((item.imageResourceId))
        holder.itemView.setOnClickListener {
            listener(item)
        }
    }
}