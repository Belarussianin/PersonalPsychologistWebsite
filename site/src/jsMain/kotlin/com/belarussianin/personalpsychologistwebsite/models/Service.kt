package com.belarussianin.personalpsychologistwebsite.models

enum class Service(
    //val icon: String,
    val title: String,
    val description: String
) {
    First(
        //icon = Res.Icon.android,
        title = "1",
        description = "Проблемы с выражением и проживанием чувств и эмоций"
    ),
    Second(
        //icon = Res.Icon.apple,
        title = "2",
        description = "Самоопределение"
    ),
    Third(
        //icon = Res.Icon.web,
        title = "3",
        description = "Трудности с принятием решений"
    ),
    Fourth(
        //icon = Res.Icon.design,
        title = "4",
        description = "Утрата мотивации"
    ),
    Fifth(
        //icon = Res.Icon.business,
        title = "5",
        description = "Эмоциональное выгорание"
    ),
    Sixth(
        //icon = Res.Icon.seo,
        title = "6",
        description = "Проблемы с межличностными (в том числе и семейными) отношениями"
    )
}