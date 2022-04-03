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
import androidx.lifecycle.*
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.models.*
import com.beust.klaxon.Klaxon
import kotlinx.coroutines.*
import okhttp3.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    var client: OkHttpClient = OkHttpClient()

    /**
     * Grabs request from specified API. Returns the result (should be a string).
     */
    private fun getRequest(urlString: String): String? {
        var result: String? = null

        try {
            // Create URL
            val url = URL(urlString)

            // Create Request
            val request = Request.Builder().url(url).build()

            // Send Request
            val response = client.newCall(request).execute()
            result = response.body?.string()
        } catch (error: Error) {
            print ("Error sending request: " + error.localizedMessage)
        }
        return result
    }

    /**
     * Grabs info from requested API and parses to Album JSON class.
     */
    private fun getInfo(urlString: String): Album? {
        var albumInfo: Album? = null
        lifecycleScope.launch(Dispatchers.IO) {
            val result = getRequest(urlString)
            if (result != null) {
                // Parse result string to JSON.
                try {
                    albumInfo = Klaxon().parse<Album>(result)
                } catch (error: Error) {
                    print ("Error: JSON parse issue: " + error.localizedMessage)
                }
            } else {
                print ("Error: Request returned no response.")
            }
        }
        return albumInfo
    }

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