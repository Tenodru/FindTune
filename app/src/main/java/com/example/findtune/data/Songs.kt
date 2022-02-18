package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Song

/**
 * An object to generate static lists of song lists and albums.
 */
object Songs {

    // Top song and new song for top artists.

    // Pop
    val pop_artist1_songList: List<Song> = listOf(
        Song(
            "Top Song Name",
            "Song Link"
                ),
        Song (
            "New Song Name",
            "Song Link"
                )
    )
    val pop_artist2_songList: List<Song> = listOf(
        Song(
            "Top Song Name",
            "Song Link"
        ),
        Song (
            "New Song Name",
            "Song Link"
        )
    )

    // Hip-Hop
    val hiphop_artist1_songList: List<Song> = listOf(
        Song(
            "Top Song Name",
            "Song Link"
        ),
        Song (
            "New Song Name",
            "Song Link"
        )
    )
    val hiphop_artist2_songList: List<Song> = listOf(
        Song(
            "Top Song Name",
            "Song Link"
        ),
        Song (
            "New Song Name",
            "Song Link"
        )
    )

    // ----------------------------------------------
    // New releases for each genre.

    val pop_newReleases: List<Song> = listOf(
        Song(
            "New Release Name",
            "Song Link"
        ),
        Song (
            "New Release Name",
            "Song Link"
        ),
        Song(
            "New Release Name",
            "Song Link"
        ),
        Song (
            "New Release Name",
            "Song Link"
        )
    )

    val hiphop_newReleases: List<Song> = listOf(
        Song(
            "New Release Name",
            "Song Link"
        ),
        Song (
            "New Release Name",
            "Song Link"
        ),
        Song(
            "New Release Name",
            "Song Link"
        ),
        Song (
            "New Release Name",
            "Song Link"
        )
    )
}