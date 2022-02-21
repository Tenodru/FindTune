package com.example.findtune

import android.content.Intent
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.models.*

class ArtistScreenActivity : AppCompatActivity() {

    /**
     * Run at startup.
     * Sets the content view to the welcome screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artists_screen)
        var genre = intent.getSerializableExtra("Genre") as Genre

        val recyclerView = findViewById<RecyclerView>(R.id.vertical_recycler_view)
        recyclerView.adapter = ArtistCardAdapter(this, genre) {songItem -> goToSongLink(songItem)}
        val recyclerView2 = findViewById<RecyclerView>(R.id.new_releases_view)
        recyclerView2.adapter = NewReleasesCardAdapter(this, genre) { songItem -> goToSongLink(songItem)}
        recyclerView.setHasFixedSize(true)
    }


    fun goToSongLink(song: Song) {
        TODO("Open up song link in browser.")
    }

    // Test
}