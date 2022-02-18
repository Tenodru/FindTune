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
            "Notorious B.I.G.",
            Song (
                R.drawable.lifeafterdeath_notoriousbig,
                "Hypnotize",
                link = "https://www.youtube.com/watch?v=glEiPXAYE-U&ab_channel=TheNotoriousB.I.G"
            ),
            Song (
                R.drawable.lifeafterdeath_notoriousbig,
                "Hypnotize",
                link = "https://www.youtube.com/watch?v=glEiPXAYE-U&ab_channel=TheNotoriousB.I.G"
            )
        ),
        Artist(
            "Jay-Z",
            Song (
                R.drawable._44_jayz,
                "The Story of O.J.",
                link = "https://www.youtube.com/watch?v=RM7lw0Ovzq0&ab_channel=JayZVEVO"
            ),
            Song (
                R.drawable.watchthethrone_jayz,
                "N****s in Paris (feat. Kanye West)",
                link = "https://www.youtube.com/watch?v=gG_dA32oH44&ab_channel=KanyeWestVEVO"
            )
        ),
        Artist(
            "Eminem",
            Song (
                R.drawable.musictobemurderedby_eminem,
                "Godzilla (feat. Juice WRLD)",
                link = "https://www.youtube.com/watch?v=9XvXF1LrWgA&ab_channel=EminemMusic"
            ),
            Song (
                R.drawable.theeminemshow_eminem,
                "'Till I Collapse (feat. Nate Dogg)'",
                link = "https://www.youtube.com/watch?v=Obim8BYGnOE&ab_channel=Eminem-Topic"
            )
        ),
        Artist(
            "Rakim",
            Song (
                R.drawable.themaster_rakim,
                "When I B On Tha Mic",
                link = "https://www.youtube.com/watch?v=M34OelgSlKI&ab_channel=RakimVEVO"
            ),
            Song (
                R.drawable.themaster_rakim,
                "When I B On Tha Mic",
                link = "https://www.youtube.com/watch?v=M34OelgSlKI&ab_channel=RakimVEVO"
            )
        ),
        Artist(
            "Nas",
            Song (
                R.drawable.tomorrow_nas,
                "Tomorrow (feat. John Legend and Florian Picasso)",
                link = "https://www.youtube.com/watch?v=EwmMVTi30P0&ab_channel=johnlegendVEVO"
            ),
            Song (
                R.drawable.itwaswritten_nas,
                "If I Ruled the World (Imagine That) (feat. Lauryn Hill)",
                link = "https://www.youtube.com/watch?v=mlp-IIG9ApU&ab_channel=NasVEVO"
            )
        )
    )

    // R&B
    val rnbArtists: List<Artist> = listOf (
        Artist(
            "The Weeknd",
            Song (
                R.drawable.dawnfm,
                "Sacrifice",
                link = "https://www.youtube.com/watch?v=VafTMsrnSTU&ab_channel=TheWeekndVEVO"
            ),
            Song (
                R.drawable.afterhours,
                "Blinding Lights",
                link = "https://www.youtube.com/watch?v=4NRXx6U8ABQ&ab_channel=TheWeekndVEVO"
            )
        ),
        Artist(
            "Jhene Aiko",
            Song (
                R.drawable.wrapmeup,
                "Wrap Me Up",
                link = "https://www.youtube.com/watch?v=_oY4sy8HE6w&ab_channel=Jhen%C3%A9Aiko"
            ),
            Song (
                R.drawable.trip,
                "Sativa (feat. Swae Lee)",
                link = "https://www.youtube.com/watch?v=3tnb2o-cV_0&ab_channel=JheneAikoVEVO"
            )
        ),
        Artist(
            "Justin Bieber",
            Song (
                R.drawable.justice,
                "Peaches (feat. Daniel Caesar and Giveon)",
                link = "https://www.youtube.com/watch?v=tQ0yjYUFKAE&ab_channel=JustinBieberVEVO"
            ),
            Song (
                R.drawable.purpose,
                "Love Yourself",
                link = "https://www.youtube.com/watch?v=oyEuk8j8imI&ab_channel=JustinBieberVEVO"
            )
        ),
        Artist(
            "Artist Name",
            Song (
                R.drawable.iffy,
                "Iffy",
                link = "https://www.youtube.com/watch?v=hLpAZ8_BZS4&ab_channel=ChrisBrownVEVO"
            ),
            Song (
                R.drawable.indigo,
                "No Guidance (feat. Drake)",
                link = "https://www.youtube.com/watch?v=6L_k74BOLag&ab_channel=ChrisBrownVEVO"
            )
        ),
        Artist(
            "Doja Cat",
            Song (
                R.drawable.celebrityskin,
                "Celebrity Skin",
                link = "https://www.youtube.com/watch?v=G7JEyMDyGZ8&ab_channel=dojacatVEVO"
            ),
            Song (
                R.drawable.planether,
                "Kiss Me More",
                link = "https://www.youtube.com/watch?v=0EVVKs6DQLo&ab_channel=dojacatVEVO"
            )
        )
    )

    // Latin
    val latinArtists: List<Artist> = listOf (
        Artist(
            "Bad Bunny",
            Song (
                R.drawable.losientobb,
                "Lo Siento BB:/",
                link = "https://www.youtube.com/watch?v=NO7EtdR3Dyw&ab_channel=TainyVEVO"
            ),
            Song (
                R.drawable.elultimotourdelmundo_badbunny,
                "Dakiti",
                link = "https://www.youtube.com/watch?v=TmKh7lAwnBI&ab_channel=BadBunny"
            )
        ),
        Artist(
            "Rauw Alejandro",
            Song (
                R.drawable.suelta_rauw,
                "Suelta",
                link = "https://www.youtube.com/watch?v=n9tT0J6LX1Y&ab_channel=DimeloFlow"
            ),
            Song (
                R.drawable.viceversa_rauw,
                "Todo De Ti",
                link = "https://www.youtube.com/watch?v=CFPLIaMpGrY&ab_channel=RauwAlejandro"
            )
        ),
        Artist(
            "Karol G",
            Song (
                R.drawable.mamiii_karolg,
                "MAMIII (feat. Becky G)",
                link = "https://www.youtube.com/watch?v=vb8wloc4Xpw&ab_channel=BeckyGVEVO"
            ),
            Song (
                R.drawable.kg0516_karolg,
                "Tusa (feat. Nicki Minaj)",
                link = "https://www.youtube.com/watch?v=tbneQDc2H3I&ab_channel=KarolGVEVO"
            )
        ),
        Artist(
            "Kali Uchis",
            Song (
                R.drawable.anotherdayinamerica_kali,
                "Another Day in America (feat. Ozuna)",
                link = "https://www.youtube.com/watch?v=cw1qDzyiYW4&ab_channel=KaliUchisVEVO"
            ),
            Song (
                R.drawable.sinmiedo_kali,
                "telepatia",
                link = "https://www.youtube.com/watch?v=bn_p95HbHoQ&ab_channel=KALIUCHIS"
            )
        ),
        Artist(
            "J Balvin",
            Song (
                R.drawable.ninosonador,
                "Nino Sonador",
                link = "https://www.youtube.com/watch?v=iGSaK4ii6BY&ab_channel=jbalvinVEVO"
            ),
            Song (
                R.drawable.oasis,
                "LA CANCION (feat. Bad Bunny)",
                link = "https://www.youtube.com/watch?v=LxOTsiV4tkQ&ab_channel=BadBunny"
            )
        )
    )
}