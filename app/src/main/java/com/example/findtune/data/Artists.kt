package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Artist

/**
 * An object to generate static lists of artists, top and new, for each genre.
 */
object Artists {

    // Pop
    val popArtistsTop: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Albums.album_artist1,
            Albums.album2_artist1
            )
    )
    val popArtistsNew: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Albums.album_artist1,
            Albums.album2_artist1
        )
    )

    // Hip-Hop
    val hiphopArtistsTop: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Albums.album_artist1,
            Albums.album2_artist1
        )
    )
    val hiphopArtistsNew: List<Artist> = listOf (
        Artist(
            R.drawable.artist_placeholder,
            "Artist Name",
            Albums.album_artist1,
            Albums.album2_artist1
        )
    )
}