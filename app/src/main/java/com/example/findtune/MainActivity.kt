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

class MainActivity : AppCompatActivity() {

    /**
     * Run at startup.
     * Sets the content view to the welcome screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_screen)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setHomeAsUpIndicator(R.drawable.backbutton)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        // Welcome message stuff. When enter button is clicked, go to genre display screen.
        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener { enterGenreScreen() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * App moves to genre display screen.
     */
    private fun enterGenreScreen() {
        val intent = Intent (this, GenreScreenActivity::class.java)
        startActivity(intent)
    }


    fun goToSongLink(song: Song) {
        TODO("Open up song link in browser.")
    }

    // Test
}