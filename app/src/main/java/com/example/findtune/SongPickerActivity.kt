package com.example.findtune

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.models.Genre
import com.example.findtune.models.Song
import com.example.findtune.models.SpotifyAlbumInfo
import com.example.findtune.models.SpotifyArtistInfo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Serializable

class SongPickerActivity : AppCompatActivity() {

    lateinit var newReleasesList : MutableList<SpotifyAlbumInfo>
    lateinit var chosenAlbum: SpotifyAlbumInfo
    var chosenList = mutableListOf<SpotifyAlbumInfo>()
    var chooseLimit = 10

    lateinit var albumName : TextView
    lateinit var albumImage : ImageView
    lateinit var artistName : TextView
    lateinit var rerollButton : Button

    /**
     * Run after the New Releases button is clicked.
     * Sets the content view to the Song Picker screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_picker)
        albumName = findViewById(R.id.albumName)
        albumImage = findViewById(R.id.albumImage)
        artistName = findViewById(R.id.artistName)
        rerollButton = findViewById(R.id.rerollButton)
        newReleasesList = intent.getSerializableExtra("New Releases") as MutableList<SpotifyAlbumInfo>
        chosenAlbum = newReleasesList.random()

        chooseAlbum()
        updateDisplay()

        rerollButton.setOnClickListener{ findNewAlbum() }
    }

    private fun findNewAlbum() {
        chooseAlbum()
        updateChosenList()
    }

    /**
     * Selects a new album from the viable list of albums, then updates the display.
     */
    private fun chooseAlbum() {
        var newList = mutableListOf<SpotifyAlbumInfo>()
        newList.addAll(newReleasesList)
        println(newList)
        val viableList = newList.filterNot { chosenList.contains(it) }
        println(chosenList)
        chosenAlbum = viableList.random()
        chosenList.add(chosenAlbum)
        updateDisplay()
    }

    /**
     * Updates interface elements with info from chosenAlbum.
     */
    private fun updateDisplay() {
        if (chosenAlbum != null) {
            albumName.text = chosenAlbum.name
            albumName.setOnClickListener{ openAlbumLink() }
            lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
                val urlStream = java.net.URL(chosenAlbum.image).openStream()
                val image = BitmapFactory.decodeStream(urlStream)
                withContext(Dispatchers.Main) {
                    albumImage.setImageBitmap(image)
                    albumImage.setOnClickListener{ openAlbumLink() }
                }
            }
            var artistNameText : String = ""
            for (artist in chosenAlbum.artists) {
                if (artist == chosenAlbum.artists.last()) {
                    artistNameText += artist.name
                } else {
                    artistNameText += artist.name + ", "
                }
            }
            artistName.text = artistNameText
        }
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    /**
     * Maintains the specified length of chosenList.
     */
    private fun updateChosenList() {
        if (chosenList.count() > chooseLimit) {
            chosenList.remove(chosenList.first())
        }
    }

    /**
     * Opens the link to the song or album in a web browser.
     */
    private fun openAlbumLink() {
        if (chosenAlbum != null) {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(chosenAlbum.url)
            startActivity(openURL)
        }
    }
}