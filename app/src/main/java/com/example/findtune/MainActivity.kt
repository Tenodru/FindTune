/**
 *
 * FindTune - The New Music Exploration App
 * Developed by: Alex Kong, Ayesha Din, Catherine Kim, Neha Krishna
 * Last Updated: 02/21/2022
 *
 */

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

        // Welcome message stuff. When enter button is clicked, go to genre display screen.
        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener { enterGenreScreen() }
    }

    /**
     * App moves to genre display screen.
     */
    private fun enterGenreScreen() {
        val intent = Intent (this, GenreScreenActivity::class.java)
        startActivity(intent)
    }
}