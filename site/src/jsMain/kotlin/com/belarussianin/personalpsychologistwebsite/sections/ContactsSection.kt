package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.components.SectionTitle
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.ContactsStyle
import com.stevdza.san.kotlinbs.forms.BSInput
import com.stevdza.san.kotlinbs.models.InputValidation
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.Input
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.icons.fa.FaViber
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.RadioInput

val ContactFormStyle = CssStyle {
    base {
        Modifier
            .padding(2.cssRem)
            .backgroundColor(Theme.SecondaryContainer.rgb)
            .borderRadius(1.cssRem)
            .maxWidth(1200.px)
    }
}

val SocialButtonStyle = CssStyle {
    base {
        Modifier
            .margin(0.5.cssRem)
            .padding(1.cssRem)
            .backgroundColor(Color.white)
            .borderRadius(50.percent)
            .cursor(Cursor.Pointer)
            .transition(
                Transition.of(
                    property = "scale",
                    duration = 300.ms,
                    timingFunction = TransitionTimingFunction.Ease
                )
            )
    }
    hover {
        Modifier.transform { scale(1.1) }
    }
}

val InputStyle = CssStyle {
    base {
        Modifier
            .width(100.percent)
            .padding(1.cssRem)
            .borderRadius(0.5.cssRem)
            .border(0.px)
            .fontSize(1.cssRem)
            .backgroundColor(Color.white)
    }
}

@Composable
fun ContactsSection() {
    val breakpoint = rememberBreakpoint()
    Column(
        ContactsStyle.toModifier().id(Section.Contacts.id),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(bottom = 25.px),
            section = Section.Contacts,
            breakpoint = breakpoint,
            alignment = Alignment.CenterHorizontally
        )

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var consultationType by remember { mutableStateOf("video") }

        Column(
            modifier = ContactFormStyle.toModifier(),
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().margin(bottom = 2.cssRem),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.fillMaxWidth(40.percent)) {
                    SpanText(
                        "Свяжитесь со мной напрямую",
                        modifier = Modifier.fontSize(1.25.cssRem).margin(bottom = 1.cssRem)
                    )
                    Row(
                        modifier = Modifier.gap(48.px)
                    ) {
                        Link(
                            path = "viber://chat?number=%2B375291925218",
                            modifier = Modifier.size(30.px)
                        ) {
                            FaViber(
                                modifier = SocialButtonStyle.toModifier(),
                                size = IconSize.X2
                            )
                        }

                        Link(
                            path = "https://t.me/+375291925218",
                            modifier = Modifier.size(30.px)
                        ) {
                            FaTelegram(
                                modifier = SocialButtonStyle.toModifier(),
                                size = IconSize.X2
                            )
                        }
                    }
                }

                Column(modifier = Modifier.fillMaxWidth(55.percent)) {
                    SpanText(
                        "Запишитесь на онлайн прием к психологу",
                        modifier = Modifier.fontSize(1.25.cssRem).margin(bottom = 1.cssRem)
                    )

                    Input(
                        type = InputType.Text,
                        value = name,
                        onValueChange = { name = it },
                        modifier = InputStyle.toModifier().margin(bottom = 1.cssRem).id("name"),
                        placeholder = "Ваше имя"
                    )

                    BSInput(
                        modifier = Modifier.margin(bottom = 1.cssRem),
                        id = "email",
                        placeholder = "Ваша эл. почта",
                        type = InputType.Email,
                        value = email,
                        onValueChange = { email = it },
                        validation = InputValidation()
                    )

//                    Input(
//                        type = InputType.Text,
//                        value = email,
//                        onValueChange = { email = it },
//                        modifier = InputStyle.toModifier().margin(bottom = 1.cssRem).id("email"),
//                        placeholder = "Ваша эл. почта"
//                    )

                    SpanText(
                        "Выберите формат консультации",
                        modifier = Modifier.margin(bottom = 1.cssRem)
                    )

                    Column(modifier = Modifier.margin(bottom = 1.cssRem)) {
                        Row(
                            modifier = Modifier.margin(bottom = 0.5.cssRem),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioInput {
                                checked(consultationType == "video")
                                onChange { consultationType = "video" }
                            }
                            SpanText("Видео консультация", modifier = Modifier.margin(left = 0.5.cssRem))
                        }
                        Row(
                            modifier = Modifier.margin(bottom = 0.5.cssRem),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioInput {
                                checked(consultationType == "text")
                                onChange { consultationType = "text" }
                            }
                            SpanText("Текстовая", modifier = Modifier.margin(left = 0.5.cssRem))
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioInput {
                                checked(consultationType == "undecided")
                                onChange { consultationType = "undecided" }
                            }
                            SpanText("Еще не определился с форматом", modifier = Modifier.margin(left = 0.5.cssRem))
                        }
                    }

                    Button(
                        onClick = { /* Handle form submission */ },
                        modifier = Modifier
                            .backgroundColor(Color("#4a4e69"))
                            .color(Color.white)
                            .padding(1.cssRem, 2.cssRem)
                            .borderRadius(2.cssRem)
                            .border(0.px)
                            .textAlign(TextAlign.Center)
                            .cursor(Cursor.Pointer)
//                            .hover(
//                                Modifier.backgroundColor(Color("#3d405b"))
//                            )
                    ) {
                        SpanText("Записаться")
                    }

                    SpanText(
                        "Нажимая на кнопку «Записаться» я даю согласие на обработку персональных данных и соглашаюсь с ",
                        modifier = Modifier.fontSize(0.875.cssRem).color(Color.gray)
                            .margin(top = 1.cssRem)
                    )
                    Link(
                        path = "#",
                        modifier = Modifier.fontSize(0.875.cssRem).textDecorationLine(TextDecorationLine.Underline)
                    ) {
                        SpanText("Политикой конфиденциальности")
                    }
                }
            }
        }
    }

//        Column(
//            Modifier
//                .fillMaxWidth()
//                .padding(leftRight = 24.px),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            // Contact Section
//            Column(
//                Modifier.fillMaxWidth().margin(bottom = 48.px),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                H1(
//                    attrs = Modifier
//                        .margin(bottom = 16.px)
//                        .color(hexToRGBA("#1F4B5B"))
//                        .fontSize(48.px)
//                        .fontWeight(FontWeight.Normal)
//                        .textAlign(TextAlign.Center)
//                        .toAttrs()
//                ) {
//                    Text("Обсудим ваш вопрос ?")
//                }
//
//                P(
//                    attrs = Modifier
//                        .margin(bottom = 32.px)
//                        .color(hexToRGBA("#1F4B5B"))
//                        .fontSize(16.px)
//                        .maxWidth(600.px)
//                        .textAlign(TextAlign.Center)
//                        .lineHeight(1.5)
//                        .toAttrs()
//                ) {
//                    Text("В процессе разговора вы расскажете о своей проблеме, а я помогу вам определиться с планом её решения на консультации")
//                }
//
//                Button(
//                    attrs = ContactsButtonStyle.toModifier()
//                        .margin(bottom = 48.px)
//                        .toAttrs()
//                ) {
//                    Text("Обсудить ваш запрос")
//                }
//
//                Row(
//                    Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Column(
//                        Modifier.fillMaxWidth(50.percent),
//                        horizontalAlignment = Alignment.Start
//                    ) {
//                        Link(
//                            path = "tel:+79299413565",
//                            modifier = ContactsLinkStyle.toModifier()
//                                .fontSize(32.px)
//                                .fontWeight(FontWeight.Normal)
//                                .margin(bottom = 8.px)
//                        ) {
//                            Text("+7 929 941-35-65")
//                        }
//
//                        Link(
//                            path = "mailto:julia.sky360@yandex.ru",
//                            modifier = ContactsLinkStyle.toModifier()
//                                .fontSize(24.px)
//                                .fontWeight(FontWeight.Normal)
//                        ) {
//                            Text("julia.sky360@yandex.ru")
//                        }
//                    }
//
//                    // Social Media Icons
//                    Row(
//                        Modifier.fillMaxWidth(50.percent).gap(24.px),
//                        horizontalArrangement = Arrangement.End,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Link(
//                            path = "viber://chat?number=%2B375291925218",
//                            modifier = Modifier.size(48.px)
//                        ) {
//                            FaViber(
//                                modifier = SocialLinkStyle.toModifier(),
//                                size = IconSize.X3
//                            )
//                        }
//
//                        Link(
//                            path = "https://t.me/+375291925218",
//                            modifier = Modifier.size(48.px)
//                        ) {
//                            FaTelegram(
//                                modifier = SocialLinkStyle.toModifier(),
//                                size = IconSize.X3
//                            )
//                        }
//                    }
//                }
//            }
//        }
}