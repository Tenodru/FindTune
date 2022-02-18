package com.example.findtune.models;

import androidx.annotation.DrawableRes

/**
 * A data class to represent genre information.
 */
data class Genre(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val topArtists: List<Artist>,
    val newReleases: List<Song>
)

/**
 * A data class to represent the information presented in artist cards.
 */
data class Artist(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val songs: List<Song>
)

/**
 * A data class to represent song information.
 * Link parameter is the link to the song on YT or Spotify.
 */
data class Song(
    val name: String,
    val link: String
)