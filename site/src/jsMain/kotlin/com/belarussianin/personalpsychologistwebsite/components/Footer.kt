package com.belarussianin.personalpsychologistwebsite.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(rgb(248, 249, 250))
            .margin(top = 50.px)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(1200.px)
                .styleModifier {
                    property("margin-left", "auto")
                    property("margin-right", "auto")
                }
                .margin(topBottom = 40.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpanText(
                "© 2024 Психолог Екатерина Ермихина",
                modifier = Modifier
                    .color(rgb(108, 117, 125))
                    .fontSize(14.px)
                    .margin(bottom = 10.px)
            )

            SpanText(
                "г. Москва",
                modifier = Modifier
                    .color(rgb(108, 117, 125))
                    .fontSize(14.px)
            )
        }
    }
}