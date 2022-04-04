/**
 *
 * FindTune - The New Music Exploration App
 * Developed by: Alex Kong, Ayesha Din, Catherine Kim, Neha Krishna
 * Last Updated: 02/21/2022
 *
 */

package com.example.findtune

// Spotify
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.beust.klaxon.Klaxon
import com.example.findtune.models.AlbumList
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL


class MainActivity : AppCompatActivity() {

    val viewModel: ActivityViewModel by viewModels()

    var client: OkHttpClient = OkHttpClient()
    val CLIENT_ID = "ce611d227701449c8d64d78688d1cf96"
    val REDIRECT_URI = "http://localhost:8888/callback"
    val AUTH_TOKEN_REQUEST_CODE = 0x10
    var accessToken = ""

    /**
     * Grabs request from specified API. Returns the result (should be a string).
     */
    private fun getRequest(urlString: String): String? {
        var result: String? = null
        print ("Access? " + accessToken)

        try {
            // Create URL
            val url = URL(urlString)

            // Create Request
            val request = Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + accessToken)
                .build()

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
    private fun getInfo(urlString: String): AlbumList? {
        var albumInfo: AlbumList? = null
        lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = getRequest(urlString)
            if (result != null) {
                // Parse result string to JSON.
                try {
                    println("Result: " + result)
                    albumInfo = Klaxon().parse<AlbumList>(result)

                    withContext(Dispatchers.Main) {
                        //viewModel.albumName.value = albumInfo?.name
                        println(albumInfo)
                    }
                } catch (error: Error) {
                    print ("Error: JSON parse issue: " + error.localizedMessage)
                }
            } else {
                print ("Error: Request returned no response.")
            }
        }
        return albumInfo
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
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

        // New code
        val fetchButton: Button = findViewById(R.id.fetchButton)
        //fetchButton.setOnClickListener { getInfo("https://api.spotify.com/v1/browse/new-releases") }
        fetchButton.setOnClickListener {
            val request = getAuthenticationRequest(AuthenticationResponse.Type.TOKEN)
            AuthenticationClient.openLoginActivity(
                this,
                AUTH_TOKEN_REQUEST_CODE,
                request
            )
        }
    }

    private fun getAuthenticationRequest(type: AuthenticationResponse.Type): AuthenticationRequest {
        return AuthenticationRequest.Builder(CLIENT_ID, type, REDIRECT_URI)
            .setShowDialog(false)
            .build()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            val response = AuthenticationClient.getResponse(resultCode, data)
            accessToken = response.accessToken
            getInfo("https://api.spotify.com/v1/browse/new-releases")
        }
    }

    /**
     * App moves to genre display screen.
     */
    private fun enterGenreScreen() {
        val intent = Intent (this, GenreScreenActivity::class.java)
        startActivity(intent)
    }
}