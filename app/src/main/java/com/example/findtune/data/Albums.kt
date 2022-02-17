package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Album
import com.example.findtune.models.Song

/**
 * An object to generate static lists of song lists and albums.
 */
object Albums {

    // Each Songlist corresponds to a particular album.
    // All Songlists must be initialized before their corresponding album.
    val album_artist1_songList: List<Song> = listOf(
        Song(
            "Song Name",
            "Song Link"
        )
    )
    val album2_artist1_songList: List<Song> = listOf(
        Song(
            "Song Name",
            "Song Link"
        )
    )

    val album_artist1: Album = Album(
        R.drawable.album_placeholder,
        "AlbumName",
        "2/17/2022",
        album_artist1_songList
    )

    val album2_artist1: Album = Album(
        R.drawable.album_placeholder,
        "AlbumName",
        "2/17/2022",
        album2_artist1_songList
    )
}