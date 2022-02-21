/**
 *
 * FindTune - The New Music Exploration App
 * Developed by: Alex Kong, Ayesha Din, Catherine Kim, Neha Krishna
 * Last Updated: 02/21/2022
 *
 */

package com.example.findtune

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.models.*

class GenreScreenActivity : AppCompatActivity() {

    /**
     * Run after enter button is clicked.
     * Sets the content view to the genre list screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres_screen)

        val recyclerView = findViewById<RecyclerView>(R.id.grid_recycler_view)
        recyclerView.adapter = GenreCardAdapter(this) {genreItem -> enterArtistScreen(genreItem)}
        recyclerView.setHasFixedSize(true)
    }

    /**
     * App moves to artist display screen.
     */
    fun enterArtistScreen(genre: Genre) {
        //Toast.makeText(this, genre.topArtists[0].name, Toast.LENGTH_SHORT).show()
        val intent = Intent (this, ArtistScreenActivity::class.java)
        intent.putExtra("Genre", genre)
        startActivity(intent)
    }
}