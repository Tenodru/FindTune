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
            "Taylor Swift",
            Song (
                R.drawable.taylorswiftalltoowell,
                "All Too Well (10 Minute Version) (Taylor's Version)",
                link = "https://www.youtube.com/watch?v=tollGa3S0o8&ab_channel=TaylorSwiftVEVO"
                    ),
            Song (
                R.drawable.taylorswiftblankspace,
                "Blank Space",
                link = "https://www.youtube.com/watch?v=e-ORhEE9VVg&ab_channel=TaylorSwiftVEVO"
                    )
        ),
        Artist(
            "Lil Nas X",
            Song (
                R.drawable.lilnasxindustrybaby,
                "INDUSTRY BABY (feat. Jack Harlow)",
                link = "https://www.youtube.com/watch?v=UTHLKHL_whs&ab_channel=LilNasXVEVO"
            ),
            Song (
                R.drawable.lilnasxmontero,
                "MONTERO (Call Me By Your Name)",
                link = "https://www.youtube.com/watch?v=6swmTBVI83k"
            )
        ),
        Artist(
            "Adele",
            Song (
                R.drawable.adeleeasyonme,
                "Easy On Me",
                link = "https://www.youtube.com/watch?v=U3ASj1L6_sY&ab_channel=AdeleVEVO"
            ),
            Song (
                R.drawable.adelehello,
                "Hello",
                link = "https://www.youtube.com/watch?v=YQHsXMglC9A&ab_channel=AdeleVEVO"
            )
        ),
        Artist(
            "Doja Cat",
            Song (
                R.drawable.dojacatcelebrityskin,
                "Celebrity Skin (feat. SZA)",
                link = "https://www.youtube.com/watch?v=G7JEyMDyGZ8&ab_channel=dojacatVEVO"
            ),
            Song (
                R.drawable.dojacatkissmemore,
                "Kiss Me More",
                link = "https://www.youtube.com/watch?v=0EVVKs6DQLo&ab_channel=dojacatVEVO"
            )
        ),Artist(
            "The Weeknd",
            Song (
                R.drawable.theweekndrecent,
                "Sacrifice",
                link = "https://www.youtube.com/watch?v=VafTMsrnSTU&ab_channel=TheWeekndVEVO"
            ),
            Song (
                R.drawable.theweekndtop,
                "Blinding Lights",
                link = "https://www.youtube.com/watch?v=4NRXx6U8ABQ&ab_channel=TheWeekndVEVO"
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

    // Country
    val countryArtists: List<Artist> = listOf (
        Artist(
            "Morgan Wallen",
            Song (
                R.drawable.morganwallenmorethanmyhometown,
                "More Than My Hometown",
                link = "https://www.youtube.com/watch?v=MS82JAkBkDY&ab_channel=MorganWallenVEVO"
            ),
            Song (
                R.drawable.morganwallenwhiskeyglasses,
                "Whiskey Glasses",
                link = "https://www.youtube.com/watch?v=FjBp30kjzTc&ab_channel=MorganWallenVEVO"
            )
        ),
        Artist(
            "Luke Combs",
            Song (
                R.drawable.lukecombsdointhis,
                "Doin' This",
                link = "https://www.youtube.com/watch?v=2YSqaI3IBpo&ab_channel=LukeCombsVEVO"
            ),
            Song (
                R.drawable.lukecombsbeautifulcrazy,
                "Beautiful Crazy",
                link = "https://www.youtube.com/watch?v=rItv9i6c7AY&ab_channel=LukeCombsVEVO"
            )
        ),
        Artist(
            "Chris Stapleton",
            Song (
                R.drawable.chrisstapletonstartingover,
                "Starting Over",
                link = "https://www.youtube.com/watch?v=A3svABDnmio&ab_channel=ChrisStapletonVEVO"
            ),
            Song (
                R.drawable.chrisstapletontennesseewhiskey,
                "Tennessee Whiskey",
                link = "https://www.youtube.com/watch?v=4zAThXFOy2c&ab_channel=ChrisStapletonVEVO"
            )
        ),
        Artist(
            "Gabby Barrett",
            Song (
                R.drawable.gabbybarrett,
                "I Hope",
                link = "https://www.youtube.com/watch?v=qcCH6JpcK5w&ab_channel=GabbyBarrett"
            ),
            Song (
                R.drawable.gabbybarrett,
                "I Hope",
                link = "https://www.youtube.com/watch?v=qcCH6JpcK5w&ab_channel=GabbyBarrett"
            )
        ),
        Artist(
            "Luke Bryan",
            Song (
                R.drawable.tomorrow_nas,
                "Songs You Never Heard",
                link = "https://www.youtube.com/watch?v=g8Kc7ux-TYg&ab_channel=LukeBryan-Topic"
            ),
            Song (
                R.drawable.itwaswritten_nas,
                "Play It Again",
                link = "https://www.youtube.com/watch?v=ALV-QtDFpSw&ab_channel=LukeBryanVEVO"
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

    // Rock
    val rockArtists: List<Artist> = listOf (
        Artist(
            "Glass Animals",
            Song (
                R.drawable.glassanimalsidontwannatalk,
                "I Don't Wanna Talk (I Just Wanna Dance)",
                link = "https://www.youtube.com/watch?v=9nrEaHinGmY&ab_channel=GlassAnimalsVEVO"
            ),
            Song (
                R.drawable.glassanimalsheatwaves,
                "Heat Waves",
                link = "https://www.youtube.com/watch?v=mRD0-GxqHVo&ab_channel=GlassAnimalsVEVO"
            )
        ),
        Artist(
            "Machine Gun Kelly",
            Song (
                R.drawable.mgkemogirl,
                "emo girl (feat. WILLOW)",
                link = "https://www.youtube.com/watch?v=yh_ydvIJAxg&ab_channel=MGKVEVO"
            ),
            Song (
                R.drawable.mgkbadthings,
                "Bad Things (feat. Camila Cabello)",
                link = "https://www.youtube.com/watch?v=QpbQ4I3Eidg&ab_channel=MGKVEVO"
            )
        ),
        Artist(
            "Imagine Dragons",
            Song (
                R.drawable.imaginedragonsenemy,
                "Enemy (with J.I.D)",
                link = "https://www.youtube.com/watch?v=D9G1VOjN_84&ab_channel=ImagineDragonsVEVO"
            ),
            Song (
                R.drawable.imaginedragonsbeliever,
                "Believer",
                link = "https://www.youtube.com/watch?v=7wtfhZwyrcc&ab_channel=ImagineDragonsVEVO"
            )
        ),
        Artist(
            "Fleetwood Mac",
            Song (
                R.drawable.fmacmadisonblues,
                "Madison Blues",
                link = "https://www.youtube.com/watch?v=XNWmcMKMyXs&ab_channel=fleetwoodmacVEVO"
            ),
            Song (
                R.drawable.fmacdreams,
                "Dreams",
                link = "https://www.youtube.com/watch?v=Y3ywicffOj4&ab_channel=FleetwoodMac"
            )
        ),
        Artist(
            "AJR",
            Song (
                R.drawable.ajrrecordplayer,
                "Record Player (feat. Daisy the Great)",
                link = "https://www.youtube.com/watch?v=3x2xtPV9oxQ&ab_channel=DaisytheGreat"
            ),
            Song (
                R.drawable.ajrweak,
                "Weak",
                link = "https://www.youtube.com/watch?v=txCCYBMKdB0&ab_channel=AJR"
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

    // Jazz
    val jazzArtists: List<Artist> = listOf (
        Artist(
            "Nils",
            Song (
                R.drawable.tripampool,
                "Trip am Pool",
                link = "https://www.youtube.com/watch?v=OF6ZD5zemKc&ab_channel=Nils-Topic"
            ),
            Song (
                R.drawable.pacificcoasthighway,
                "Summer Nights",
                link = "https://www.youtube.com/watch?v=7gNhXe-TJYE&ab_channel=Nils-Topic"
            )
        ),
        Artist(
            "Gerald Albright",
            Song (
                R.drawable.gstream,
                "Hope",
                link = "https://www.youtube.com/watch?v=ITm1tvuoNHo&ab_channel=GeraldAlbright-Topic"
            ),
            Song (
                R.drawable.slamdunk,
                "Because of You",
                link = "https://www.youtube.com/watch?v=iKBx3xNGJmQ&ab_channel=swisslion11"
            )
        ),
        Artist(
            "Adam Hawley",
            Song (
                R.drawable.risinup,
                "Risin' Up",
                link = "https://www.youtube.com/watch?v=JrUjxdtN4mQ&ab_channel=AdamHawley-Topic"
            ),
            Song (
                R.drawable.doublevision,
                "Just Dance",
                link = "https://www.youtube.com/watch?v=dj18_9FRyh8&ab_channel=AdamHawley-Topic"
            )
        ),
        Artist(
            "Richard Elliot",
            Song (
                R.drawable.authenticlife,
                "Snapshot",
                link = "https://www.youtube.com/watch?v=CWjTsWpGsyw&ab_channel=Stereophile1isback"
            ),
            Song (
                R.drawable.chillfactor,
                "Chill Factor",
                link = "https://www.youtube.com/watch?v=Xqn87Kcep_s&ab_channel=RobertoCastillo2184"
            )
        ),
        Artist(
            "Jeff Ryan",
            Song (
                R.drawable.duality,
                "Double Up",
                link = "https://www.youtube.com/watch?v=EizOg2_-Fhk&ab_channel=JeffRyan-Topic"
            ),
            Song (
                R.drawable.embrace,
                "Embrace",
                link = "https://www.youtube.com/watch?v=b97A2vMte1M&ab_channel=JeffRyan-Topic"
            )
        )
    )

    // K-Pop
    val kpopArtists: List<Artist> = listOf (
        Artist(
            "BTS",
            Song (
                R.drawable.btsmyuniverse,
                "My Universe",
                link = "https://www.youtube.com/watch?v=3YqPKLZF_WU&ab_channel=Coldplay"
            ),
            Song (
                R.drawable.btsdynamite,
                "Dynamite",
                link = "https://www.youtube.com/watch?v=gdZLi9oWNZg&ab_channel=HYBELABELS"
            )
        ),
        Artist(
            "Blackpink",
            Song (
                R.drawable.blackpinklovesickgirls,
                "Lovesick Girls",
                link = "https://www.youtube.com/watch?v=dyRsYk0LyA8&ab_channel=BLACKPINK"
            ),
            Song (
                R.drawable.blackpinkhowyoulikethat,
                "How You Like That",
                link = "https://www.youtube.com/watch?v=ioNng23DkIM&ab_channel=BLACKPINK"
            )
        ),
        Artist(
            "Seventeen",
            Song (
                R.drawable.seventeenrockwithyou,
                "Rock With You",
                link = "https://www.youtube.com/watch?v=WpuatuzSDK4&ab_channel=HYBELABELS"
            ),
            Song (
                R.drawable.seventeendontwannacry,
                "Don't Wanna Cry",
                link = "Shttps://www.youtube.com/watch?v=zEkg4GBQumc&ab_channel=SEVENTEEN"
            )
        ),
        Artist(
            "ITZY",
            Song (
                R.drawable.itzyweapon,
                "Weapon",
                link = "https://www.youtube.com/watch?v=KJrPsT2X-yk&ab_channel=ITZY-Topic"
            ),
            Song (
                R.drawable.itzywannabe,
                "Wannabe",
                link = "https://www.youtube.com/watch?v=fE2h3lGlOsk&ab_channel=JYPEntertainment"
            )
        ),
        Artist(
            "Enhypen",
            Song (
                R.drawable.enhypenfever,
                "Fever",
                link = "https://www.youtube.com/watch?v=X7d6Dt17yHk&ab_channel=HYBELABELS"
            ),
            Song (
                R.drawable.enhypenfever,
                "Fever",
                link = "https://www.youtube.com/watch?v=X7d6Dt17yHk&ab_channel=HYBELABELS"
            )
        )
    )
}