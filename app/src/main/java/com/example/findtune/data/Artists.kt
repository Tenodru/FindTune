package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Artist

/**
 * An object to generate static lists of artists, top and new, for each genre.
 */
object Artists {

    // Pop
    val popArtists: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Songs.pop_artist1_songList
            ),
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Songs.pop_artist2_songList
        )
    )

    // Hip-Hop
    val hiphopArtists: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Songs.hiphop_artist1_songList
        ),
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Songs.hiphop_artist2_songList
        )
    )
}