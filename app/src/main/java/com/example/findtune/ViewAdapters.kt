package com.example.findtune

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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
    private val listener: (Song) -> Unit
): RecyclerView.Adapter<ArtistCardAdapter.ArtistCardViewHolder>() {
    val artistList = genre.topArtists
    val newReleasesList = genre.newReleases

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class ArtistCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistName: TextView = itemView.findViewById(R.id.artistName)
        val recentSongImage: ImageView = itemView.findViewById(R.id.recentSongImage)
        val topSongImage: ImageView = itemView.findViewById(R.id.topSongImage)
        val recentSongName: TextView = itemView.findViewById(R.id.recentSongName)
        val topSongName: TextView = itemView.findViewById(R.id.topSongName)
        val recentSongAlbum: TextView = itemView.findViewById(R.id.recentSongEP)
        val topSongAlbum: TextView = itemView.findViewById(R.id.topSongEP)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistCardViewHolder {
        val viewLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.artist_list_item, parent, false)
        return ArtistCardViewHolder(viewLayout)
    }

    override fun getItemCount(): Int = artistList.size

    override fun onBindViewHolder(holder: ArtistCardViewHolder, position: Int) {
        val resources = context?.resources

        val item = artistList[position]
        holder.artistName.text = item.name
        holder.recentSongImage.setImageResource((item.recentSong.image))
        holder.topSongImage.setImageResource((item.topSong.image))
        holder.recentSongName.text = item.recentSong.name
        holder.topSongName.text = item.topSong.name
        holder.recentSongAlbum.text = item.recentSong.album
        holder.topSongAlbum.text = item.topSong.album

        holder.recentSongImage.setOnClickListener {
            listener(item.recentSong)
            //Toast.makeText(context, "please work", Toast.LENGTH_SHORT).show()
        }
        holder.topSongImage.setOnClickListener {
            listener(item.topSong)
            //Toast.makeText(context, "please work", Toast.LENGTH_SHORT).show()
        }
    }
}

class NewReleasesCardAdapter (
    private val context: Context?,
    private val genre: Genre,
    private val listener: (Song) -> Unit
): RecyclerView.Adapter<NewReleasesCardAdapter.NewReleasesCardViewHolder>() {
    val newReleasesList = genre.newReleases

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class NewReleasesCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val song1Image: ImageView = itemView.findViewById(R.id.song1Image)
        val song1Name: TextView = itemView.findViewById(R.id.song1Name)
        val song1Artist: TextView = itemView.findViewById(R.id.song1Artist)
        val song1Album: TextView = itemView.findViewById(R.id.song1Album)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewReleasesCardViewHolder {
        val viewLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.new_release_item, parent, false)
        return NewReleasesCardViewHolder(viewLayout)
    }

    override fun getItemCount(): Int = newReleasesList.size

    override fun onBindViewHolder(holder: NewReleasesCardViewHolder, position: Int) {
        val resources = context?.resources

        val item = newReleasesList[position]
        holder.song1Image.setImageResource((item.image))
        holder.song1Name.text = item.name
        holder.song1Artist.text = item.artist
        holder.song1Album.text = item.album

        holder.song1Image.setOnClickListener {
            listener(item)
            //Toast.makeText(context, "please work", Toast.LENGTH_SHORT).show()
        }
    }
}