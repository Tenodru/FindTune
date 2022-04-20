/**
 *
 * FindTune - The New Music Exploration App
 * Developed by: Alex Kong, Ayesha Din, Catherine Kim, Neha Krishna
 * Last Updated: 02/21/2022
 *
 */

package com.example.findtune.models;

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.beust.klaxon.Json
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable

/**
 * A data class to represent genre information.
 */
data class Genre (
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val topArtists: List<Artist>,
    val newReleases: List<Song>
) : Serializable

/**
 * A data class to represent the information presented in artist cards.
 */
data class Artist(
    val name: String,
    val recentSong: Song,
    val topSong: Song
) : Serializable

/**
 * A data class to represent song information.
 * Link parameter is the link to the song on YT or Spotify.
 */
data class Song(
    @DrawableRes val image: Int,
    val name: String,
    val artist: String = "",
    val album: String = "",
    val link: String
) : Serializable

/**
 * A data class to represent album information.
 */
data class Album(
    @DrawableRes val image: Int,
    val name: String,
    val artist: String = ""
) : Serializable

/**
 * A data class to represent album information from Spotify's API.
 */
data class SpotifyAlbumInfo (
    @Json(name = "album_type")
    val albumType: String,
    //val artists: ArrayList<String?>,
    //val images: ArrayList<String?>,
    @Json(ignored = true)
    var artists: MutableList<SpotifyArtistInfo> = mutableListOf(),
    @Json(ignored = true)
    var image: String = "",
    val name: String,
    @Json(name = "release_date")
    val releaseDate: String
) : Serializable

/**
 * A data class to represent artist information from Spotify's API.
 */
data class SpotifyArtistInfo (
    val name: String,
    val id: String
) : Serializable