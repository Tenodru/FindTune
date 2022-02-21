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

class ArtistScreenActivity : AppCompatActivity() {

    /**
     * Run after a genre is clicked.
     * Sets the content view to the artist list screen.
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

    /**
     * Application opens song link in browser.
     */
    fun goToSongLink(song: Song) {
        //Toast.makeText(this, song.link, Toast.LENGTH_SHORT).show()
        val openURL = Intent(android.content.Intent.ACTION_VIEW)
        openURL.data = Uri.parse(song.link)
        startActivity(openURL)
    }

    // Test
}