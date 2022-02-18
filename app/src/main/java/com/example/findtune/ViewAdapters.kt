package com.example.findtune

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.data.*
import com.example.findtune.models.*

/**
 * Layout adapter for the Genre layout cards.
 */
class GenreCardAdapter (
    private val context: Context?,
    private val listener: (Genre) -> Unit
        ): RecyclerView.Adapter<GenreCardAdapter.GenreCardViewHolder>() {
    val genreList = Genres.genres

    class GenreCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val genreImage : ImageView = itemView.findViewById(R.id.recentSongImage)
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
        holder.genreImage.setOnClickListener {
            listener(genreItem)
            //Toast.makeText(context, "please work", Toast.LENGTH_SHORT).show()
        }
    }
}

/**
 * Layout adapter for the Artist/New Releases layout cards.
 */
class ArtistCardAdapter (
    private val context: Context?,
    private val genre: Genre,
    private val listener: (Artist) -> Unit
): RecyclerView.Adapter<ArtistCardAdapter.ArtistCardViewHolder>() {
    val artistList = genre.topArtists
    val newReleasesList = genre.newReleases

    class ArtistCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val genreImage: ImageView = view!!.findViewById(R.id.recentSongImage)
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