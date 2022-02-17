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

class GenreCardAdapter (
    private val context: Context?
        ): RecyclerView.Adapter<GenreCardAdapter.GenreCardViewHolder>() {
    val genreList = Genres.genres

    class GenreCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val genreImage : ImageView = view!!.findViewById(R.id.genreImage)
        var genreName : String = ""
        var genreArtistsTop = listOf<Artist>()
        var genreArtistsNew = listOf<Artist>()
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
        holder.genreImage.setOnClickListener{
            fun GetPosition(): Genre {
                return (genreItem)
            }
        }
    }

}