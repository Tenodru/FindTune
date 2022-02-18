package com.example.findtune.data

import com.example.findtune.R
import com.example.findtune.models.Song

/**
 * An object to generate static lists of songs.
 */
object Songs {

    // ----------------------------------------------
    // New releases for each genre.

    val pop_newReleases: List<Song> = listOf(
        Song(
            R.drawable.album_placeholder,
            "New Release Name",
            "Artist Name",
            "Album Name",
            "Song Link"
        ),
        Song (
            R.drawable.album_placeholder,
            "New Release Name",
            "Artist Name",
            "Album Name",
            "Song Link"
        ),
        Song(
            R.drawable.album_placeholder,
            "New Release Name",
            "Artist Name",
            "Album Name",
            "Song Link"
        ),
        Song (
            R.drawable.album_placeholder,
            "New Release Name",
            "Artist Name",
            "Album Name",
            "Song Link"
        )
    )

    val hiphop_newReleases: List<Song> = listOf(
        Song(
            R.drawable.worstday,
            "Worst Day",
            "Future",
            "Worst Day",
            "https://www.youtube.com/watch?v=QmmLwWq3oy4&ab_channel=FutureVEVO"
        ),
        Song (
            R.drawable.bussin,
            "Bussin (feat. Lil Baby)",
            "Nicki Minaj",
            "Bussin",
            "https://www.youtube.com/watch?v=jU7eq75Sejs&ab_channel=NickiMinaj"
        ),
        Song(
            R.drawable.khabib,
            "Obsessed With You",
            "Central Cee",
            "Khabib",
            "https://www.youtube.com/watch?v=oP7KHC129RQ&ab_channel=CentralCee"
        ),
        Song (
            R.drawable.dietcoke,
            "Diet Coke",
            "Pusha T",
            "Diet Coke",
            "https://www.youtube.com/watch?v=HFrwm6oRYJg&ab_channel=PushaTVEVO"
        )
    )

    val rnb_newReleases: List<Song> = listOf(
        Song(
            R.drawable.invincible,
            "Invincible (feat. Daniel Caesar)",
            "Omar Apollo",
            "Invincible",
            "https://www.youtube.com/watch?v=BAKvb8qD4Cw&ab_channel=OmarApollo"
        ),
        Song (
            R.drawable.amazing,
            "Amazing (feat. DJ Khaled)",
            "Mary J. Blige",
            "Good Morning Gorgeous",
            "https://www.youtube.com/watch?v=CRZig-WX_U8&ab_channel=MaryJBlige"
        ),
        Song(
            R.drawable.wildhorses,
            "wild horses",
            "Fana Hues",
            "wild horses",
            "https://www.youtube.com/watch?v=aovDkZbnuuE&ab_channel=FanaHues"
        ),
        Song (
            R.drawable.heauxtalesmotales,
            "Pick Up Your Feelings",
            "Jazmine Sullivan",
            "Heaux Tales, Mo' Tales",
            "https://www.youtube.com/watch?v=ZeP--wHHiy8&ab_channel=JazmineSullivanVEVO"
        )
    )

    val latin_newReleases: List<Song> = listOf(
        Song(
            R.drawable.noseolvida,
            "NO SE OLVIDA",
            "Wisin & Yandel",
            "NO SE OLVIDA",
            "https://www.youtube.com/watch?v=BgnbBkzt7tU&ab_channel=WisinYYandelVEVO"
        ),
        Song (
            R.drawable.mamiii_karolg,
            "MAMIII (feat. Becky G)",
            "Karol G",
            "MAMIII",
            "https://www.youtube.com/watch?v=vb8wloc4Xpw&ab_channel=BeckyGVEVO"
        ),
        Song(
            R.drawable.maldeamores,
            "Marte",
            "Sofia Reyes and Maria Becerra",
            "Mal De Amores",
            "https://www.youtube.com/watch?v=-BLTXAciRLg&ab_channel=SofiaReyes"
        ),
        Song (
            R.drawable.caprichoso,
            "Caprichoso",
            "Rauw Alejandro",
            "Caprichoso",
            "https://www.youtube.com/watch?v=8JgxWexxnFI&ab_channel=RauwAlejandro"
        )
    )
}