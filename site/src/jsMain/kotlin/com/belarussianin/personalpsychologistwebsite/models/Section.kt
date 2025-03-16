package com.belarussianin.personalpsychologistwebsite.models

enum class Section(
    val id: String,
    val title: String,
    val subtitle: String,
    val text: String? = null,
    val path: String
) {
    Home(
        id = "home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    Services(
        id = "services",
        title = "Услуги",
        subtitle = "Основные вопросы, с которыми ко мне обращаются:",
        path = "#services"
    ),
    Reviews(
        id = "reviews",
        title = "Отзывы",
        subtitle = "",
        path = "#reviews"
    ),
    About(
        id = "about",
        title = "Обо мне",
        subtitle = "дипломированный психолог",
        text = "В своей работе я опираюсь на этические кодексы Ассоциации экзистенциально-аналитических психологов и психотерапевтов Российского психологического общества. " +
                "Это означает, что вы всегда можете рассчитывать на безусловное соблюдение ваших личных границ, " +
                "бережное и уважительное отношение, полное отсутствие дискриминации и осуждения в любой форме.",
        path = "#about"
    ),

    //TODO
//    Blog(
//        id = "blog",
//        title = "Blog",
//        subtitle = "",
//        path = "/blog"
//    ),
    Contacts(
        id = "contacts",
        title = "Контакты",
        subtitle = "",
        path = "#contacts"
    )
}