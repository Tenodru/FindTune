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
import okhttp3.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    var client: OkHttpClient = OkHttpClient()

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