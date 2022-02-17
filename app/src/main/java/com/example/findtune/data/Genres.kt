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
            Artists.popArtistsTop,
            Artists.popArtistsNew
                ),
        Genre (
            R.drawable.hiphop,
            "Hip-Hop",
            Artists.hiphopArtistsTop,
            Artists.hiphopArtistsNew
                )
    )


}
