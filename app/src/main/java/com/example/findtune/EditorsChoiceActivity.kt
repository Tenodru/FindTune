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
import com.example.findtune.data.EditorsChoiceList
import com.example.findtune.models.*
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.Serializable

class EditorsChoiceActivity : AppCompatActivity() {

    var editorsChoiceList : List<EditorsChoiceSong> = EditorsChoiceList.list
    lateinit var chosenSong: EditorsChoiceSong
    var chosenList = mutableListOf<EditorsChoiceSong>()
    var chooseLimit = 5

    lateinit var albumName : TextView
    lateinit var albumImage : ImageView
    lateinit var artistName : TextView
    lateinit var rerollButton : Button

    /**
     * Run after New Releases button is clicked.
     * Sets the content view to the Song Picker screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_picker)
        albumName = findViewById(R.id.albumName)
        albumImage = findViewById(R.id.albumImage)
        artistName = findViewById(R.id.artistName)
        rerollButton = findViewById(R.id.rerollButton)
        chosenSong = editorsChoiceList.random()

        chooseAlbum()
        updateDisplay()

        rerollButton.setOnClickListener{ findNewAlbum() }
    }

    private fun findNewAlbum() {
        chooseAlbum()
        updateChosenList()
    }

    private fun chooseAlbum() {
        lifecycleScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            var newList = mutableListOf<EditorsChoiceSong>()
            newList.addAll(editorsChoiceList)
            val viableList = newList.filterNot { chosenList.contains(it) }
            chosenSong = viableList.random()
            chosenList.add(chosenSong)
            withContext(Dispatchers.Main) {
                updateDisplay()
            }
        }
    }

    /**
     * Updates interface elements with info from chosenAlbum.
     */
    private fun updateDisplay() {
        if (chosenSong != null) {
            albumName.text = chosenSong.name
            albumName.setOnClickListener{ openAlbumLink() }
            albumImage.setImageResource(chosenSong.image)
            albumImage.setOnClickListener{ openAlbumLink() }
            var artistNameText : String = ""
            for (artist in chosenSong.artists) {
                if (artist == chosenSong.artists.last()) {
                    artistNameText += artist
                } else {
                    artistNameText += artist + ", "
                }
            }
            artistName.text = artistNameText
        }
    }

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private fun updateChosenList() {
        if (chosenList.count() > chooseLimit) {
            chosenList.remove(chosenList.first())
        }
    }

    private fun openAlbumLink() {
        if (chosenSong != null) {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(chosenSong.url)
            startActivity(openURL)
        }
    }
}