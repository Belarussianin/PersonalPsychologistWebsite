package com.belarussianin.personalpsychologistwebsite.models

import com.belarussianin.personalpsychologistwebsite.util.Res

enum class Certificate(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.certificate1,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Res.Image.certificate2,
        title = "Landing Page for NFT",
        description = "Frontend"
    ),
    Three(
        image = Res.Image.certificate3,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Res.Image.certificate4,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Res.Image.certificate5,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}