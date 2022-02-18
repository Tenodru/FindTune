package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.*

/**
 * An object to generate a static list of genres.
 */
object Genres {

    val genres: List<Genre> = listOf (
        Genre (
            R.drawable.pop,
            "Pop",
            Artists.popArtists,
            Songs.pop_newReleases
                ),
        Genre (
            R.drawable.hiphop,
            "Hip-Hop",
            Artists.hiphopArtists,
            Songs.hiphop_newReleases
                ),
        Genre (
            R.drawable.rock,
            "Rock",
            Artists.rockArtists,
            Songs.rock_newReleases
        ),
        Genre (
            R.drawable.jazz,
            "Jazz",
            Artists.jazzArtists,
            Songs.jazz_newReleases
        ),
        Genre (
            R.drawable.kpop,
            "K-Pop",
            Artists.kpopArtists,
            Songs.kpop_newReleases
        )
    )


}
