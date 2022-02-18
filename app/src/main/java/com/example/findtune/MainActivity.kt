package com.example.findtune

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.models.*

class MainActivity : AppCompatActivity() {

    /**
     * Run at startup.
     * Sets the content view to the welcome screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen)

        // Welcome message stuff. When enter button is clicked, go to genre display screen.
        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener { enterGenreScreen() }
    }

    /**
     * App moves to genre display screen.
     */
    private fun enterGenreScreen() {
        setContentView(R.layout.activity_genres_screen)
        val recyclerView = findViewById<RecyclerView>(R.id.grid_recycler_view)
        recyclerView.adapter = GenreCardAdapter(this) {genreItem -> enterArtistScreen(genreItem)}
        recyclerView.setHasFixedSize(true)
    }

    fun enterArtistScreen(genre: Genre) {
        Toast.makeText(this, genre.topArtists[0].name, Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_artists_screen)
        val recyclerView = findViewById<RecyclerView>(R.id.vertical_recycler_view)
        recyclerView.adapter = ArtistCardAdapter(this, genre) {songItem -> goToSongLink(songItem)}
    }

    fun goToSongLink(song: Song) {
        TODO("Open up song link in browser.")
    }

    // Test
}