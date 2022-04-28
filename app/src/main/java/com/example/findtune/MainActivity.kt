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

// Android
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.beust.klaxon.Klaxon
import com.example.findtune.models.SpotifyAlbumInfo
import com.example.findtune.models.SpotifyArtistInfo
import com.spotify.sdk.android.authentication.LoginActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.Serializable
import java.net.URL


class MainActivity : AppCompatActivity() {

    val viewModel: ActivityViewModel by viewModels()

    var client: OkHttpClient = OkHttpClient()
    val CLIENT_ID = "ce611d227701449c8d64d78688d1cf96"
    var REDIRECT_URI = "findtune://callback"
    lateinit var REDIRECT_URI_2 : Uri
    val AUTH_TOKEN_REQUEST_CODE = 0x10
    var accessToken = ""

    lateinit var discoverButton: Button
    lateinit var newReleasesButton: Button
    lateinit var editorsChoiceButton: Button
    var discoverOptionsShown: Boolean = false

    var albumList = mutableListOf<SpotifyAlbumInfo>()
    lateinit var songPickerIntent : Intent

    lateinit var webView : WebView

    /**
     * Grabs request from specified API. Returns the result (should be a JSONObject).
     */
    private fun getRequest(urlString: String): JSONObject? {
        var result: JSONObject? = null
        println ("Access? " + accessToken)

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
            result = JSONObject(response.body?.string())
            println ("Response: " + result)
        } catch (error: Error) {
            println ("Error sending request: " + error.localizedMessage)
        }
        return result
    }

    /**
     * Grabs request from specified API. Returns the result (should be a string).
     */
    private fun getRequestStr(urlString: String): String? {
        var result: String? = null
        println ("Access? " + accessToken)

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
            println ("Response: " + result)
        } catch (error: Error) {
            println ("Error sending request: " + error.localizedMessage)
        }
        return result
    }

    /**
     * Grabs info from requested API and parses to a list of SpotifyAlbumInfo objects.
     * Runs within a coroutine.
     */
    private fun getInfo(urlString: String) {
        lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            val result = getRequest(urlString)

            if (result != null) {
                // Parse result string to JSON.
                try {
                    println("Result: " + result)

                    // First, grab the "items" component of the JSON result and parse to a JSONArray.
                    var testInfo = result.getJSONObject("albums").getJSONArray("items")
                    println ("TestInfo :" + testInfo)

                    // Parse through JSONArray and translate to a SpotifyAlbumInfo data object.
                    // Then add the object to the albumList.
                    for (al in 0 until testInfo.length()) {
                        val album = testInfo.getJSONObject(al)
                        println ("Album: " + album)
                        val spotifyAlbum = Klaxon().parse<SpotifyAlbumInfo>(album.toString())!!
                        val artistsArr = album.getJSONArray("artists")
                        var spotifyArtists = mutableListOf<SpotifyArtistInfo>()
                        for (ar in 0 until artistsArr.length()) {
                            spotifyArtists.add(Klaxon().parse<SpotifyArtistInfo>(artistsArr.getJSONObject(ar).toString())!!)
                        }
                        spotifyAlbum.artists = spotifyArtists

                        // Grabs album's Spotify URL.
                        val urlObject = album.getJSONObject("external_urls")
                        spotifyAlbum.url = urlObject.getString("spotify")

                        // Grabs 300x300px image URL.
                        val imagesArr = album.getJSONArray("images")
                        spotifyAlbum.image = imagesArr.getJSONObject(1).getString("url")
                        albumList.add(spotifyAlbum)
                    }
                    println("AlbumList: " + albumList)

                    withContext(Dispatchers.Main) {
                        songPickerIntent.putExtra("New Releases", albumList as Serializable)
                        startActivity(songPickerIntent)
                    }
                } catch (error: Error) {
                    println ("Error: JSON parse issue: " + error.localizedMessage)
                }
            } else {
                println ("Error: Request returned no response.")
            }
        }
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
        REDIRECT_URI_2 = Uri.parse(this.intent.toUri(0));
        songPickerIntent = Intent (this, SongPickerActivity::class.java)

        newReleasesButton = findViewById(R.id.newReleasesButton)
        editorsChoiceButton = findViewById(R.id.editorsChoiceButton)

        // Welcome message stuff. When enter button is clicked, go to genre display screen.
        val enterButton: Button = findViewById(R.id.enterButton)
        enterButton.setOnClickListener { enterGenreScreen() }

        // Tapping Discover button reveals New Releases and Editors' Choice buttons.
        discoverButton = findViewById(R.id.discoverButton)
        discoverButton.setOnClickListener {
            toggleDiscoverOptions()
            println(REDIRECT_URI_2)
        }

        newReleasesButton.setOnClickListener { getInfo("https://api.spotify.com/v1/browse/new-releases") }
        newReleasesButton.setOnClickListener {
            val request = getAuthenticationRequest(AuthenticationResponse.Type.TOKEN)
            AuthenticationClient.openLoginActivity(this, AUTH_TOKEN_REQUEST_CODE, request)
            //AuthenticationClient.openLoginInBrowser(this, request)
        }

        editorsChoiceButton.setOnClickListener{ enterEditorsChoiceScreen() }
    }

    /**
     * Handles button animations.
     */
    private fun toggleDiscoverOptions() {
        if (discoverOptionsShown) {
            val animatorNR = ObjectAnimator.ofFloat(newReleasesButton, View.TRANSLATION_Y, -60f)
            animatorNR.disableViewDuringAnimation(discoverButton)
            animatorNR.start()
            val animatorNRFade = ObjectAnimator.ofFloat(newReleasesButton, View.ALPHA, 0f)
            animatorNRFade.duration = 62
            animatorNRFade.start()
            val animatorEC = ObjectAnimator.ofFloat(editorsChoiceButton, View.TRANSLATION_Y, -140f)
            animatorEC.disableViewDuringAnimation(discoverButton)
            animatorEC.start()
            val animatorECFade = ObjectAnimator.ofFloat(editorsChoiceButton, View.ALPHA, 0f)
            animatorECFade.duration = 125
            animatorECFade.start()
            discoverOptionsShown = false
        } else {
            val animatorNR = ObjectAnimator.ofFloat(newReleasesButton, View.TRANSLATION_Y, 190f)
            animatorNR.disableViewDuringAnimation(discoverButton)
            animatorNR.start()
            val animatorNRFade = ObjectAnimator.ofFloat(newReleasesButton, View.ALPHA, 1f)
            animatorNRFade.start()
            val animatorEC = ObjectAnimator.ofFloat(editorsChoiceButton, View.TRANSLATION_Y, 360f)
            animatorEC.disableViewDuringAnimation(discoverButton)
            animatorEC.start()
            val animatorECFade = ObjectAnimator.ofFloat(editorsChoiceButton, View.ALPHA, 1f)
            animatorECFade.start()
            discoverOptionsShown = true
        }
    }

    /**
     * Disables the specified view while an animation plays.
     */
    private fun ObjectAnimator.disableViewDuringAnimation(view: View) {
        //TODO: disable buttons while animating
        addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                view.isEnabled = false
            }
            override fun onAnimationEnd(animation: Animator?) {
                view.isEnabled = true
            }
        })
    }

    /**
     * Makes an authentication request.
     */
    private fun getAuthenticationRequest(type: AuthenticationResponse.Type): AuthenticationRequest {
        return AuthenticationRequest.Builder(CLIENT_ID, type, REDIRECT_URI)
            .setShowDialog(true)
            .build()
    }

    /**
     * Handles the user's Spotify login result.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (AUTH_TOKEN_REQUEST_CODE == requestCode) {
            val response = AuthenticationClient.getResponse(resultCode, data)
            if (response.accessToken == null) {
                //setContentView(R.layout.welcome_screen)
                AuthenticationClient.stopLoginActivity(this, AUTH_TOKEN_REQUEST_CODE)
            } else {
                accessToken = response.accessToken
                getInfo("https://api.spotify.com/v1/browse/new-releases")
            }
        }
    }

    /**
     * Used for web browser login method.
     */
    override fun onNewIntent(intent: Intent)
    {
        super.onNewIntent(intent);
        println("Back to app.")

        var uri : Uri? = intent.data;
        if (uri != null) {
            var response : AuthenticationResponse = AuthenticationResponse.fromUri(uri);

            when (response.getType()) {
                // Response was successful and contains auth token.
                AuthenticationResponse.Type.TOKEN -> {
                    // Handle successful response
                    accessToken = response.accessToken
                    getInfo("https://api.spotify.com/v1/browse/new-releases")
                }

                // Auth flow returned an error.
                AuthenticationResponse.Type.ERROR -> {
                    // Handle error response
                    println(response.error)
                }

                // Most likely auth flow was cancelled.
                else -> {
                    // Handle other cases

                }
            }
        }
    }

    /**
     * App moves to genre display screen.
     */
    private fun enterGenreScreen() {
        val genreIntent = Intent (this, GenreScreenActivity::class.java)
        startActivity(genreIntent)
    }

    /**
     * App moves to Editors' Choice picker screen.
     */
    private fun enterEditorsChoiceScreen() {
        val ecIntent = Intent (this, EditorsChoiceActivity::class.java)
        startActivity(ecIntent)
    }
}