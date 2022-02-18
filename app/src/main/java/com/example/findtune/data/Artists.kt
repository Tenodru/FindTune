package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Artist
import com.example.findtune.models.Song

/**
 * An object to generate static lists of artists, top and new, for each genre.
 */
object Artists {

    // Pop
    val popArtists: List<Artist> = listOf (
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
                    ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
                    )
            ),
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        )
    )

    // Hip-Hop
    val hiphopArtists: List<Artist> = listOf (
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        ),
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        )
    )

    // R&B
    val rnbArtists: List<Artist> = listOf (
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        ),
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        )
    )

    // Latin
    val latinArtists: List<Artist> = listOf (
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        ),
        Artist(
            "Artist Name",
            Song (
                R.drawable.album_placeholder,
                "Recent Song Name",
                link = "Song Link"
            ),
            Song (
                R.drawable.album_placeholder,
                "Top Song Name",
                link = "Song Link"
            )
        )
    )
}