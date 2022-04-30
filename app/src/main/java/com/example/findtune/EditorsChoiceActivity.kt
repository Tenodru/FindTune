package com.example.findtune

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.findtune.data.EditorsChoiceList
import com.example.findtune.models.*
import com.google.android.material.card.MaterialCardView
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

    lateinit var header : TextView
    lateinit var albumName : TextView
    lateinit var albumImage : ImageView
    lateinit var artistName : TextView
    lateinit var rerollButton : Button
    lateinit var albumCard : MaterialCardView

    lateinit var screenLayout : ScrollView
    lateinit var albumLayout: ConstraintLayout
    lateinit var gestureDetector: GestureDetectorCompat

    /**
     * Run after the Editors' Choice button is clicked.
     * Sets the content view to the Editor's Choice Picker screen.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.song_picker)

        header = findViewById(R.id.header)
        albumName = findViewById(R.id.albumName)
        albumImage = findViewById(R.id.albumImage)
        artistName = findViewById(R.id.artistName)
        rerollButton = findViewById(R.id.rerollButton)
        albumCard = findViewById(R.id.albumCard)
        screenLayout = findViewById(R.id.scrollView)
        albumLayout = findViewById(R.id.albumLayout)

        header.text = "Editors' Choice"
        chosenSong = editorsChoiceList.random()

        chooseAlbum()
        updateDisplay()

        rerollButton.setOnClickListener{ findNewAlbum() }

        screenLayout.setOnTouchListener(object : OnSwipeTouchListener(this@EditorsChoiceActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                findNewAlbum()
            }
        })
    }

    private fun findNewAlbum() {
        chooseAlbum()
        updateChosenList()
    }

    /**
     * Selects a new song from the viable list of songs, then updates the display.
     */
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
        if (chosenSong != null) {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(chosenSong.url)
            startActivity(openURL)
        }
    }
}