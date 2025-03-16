package com.belarussianin.personalpsychologistwebsite.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.belarussianin.personalpsychologistwebsite.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SectionTitle(
    modifier: Modifier = Modifier,
    section: Section,
    breakpoint: Breakpoint,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val scope = rememberCoroutineScope()
    var titleMargin by remember { mutableStateOf(if (breakpoint > Breakpoint.SM) 250.px else 0.px) }
    var subtitleMargin by remember { mutableStateOf(if (breakpoint > Breakpoint.SM) 250.px else 0.px) }

    ObserveViewportEntered(
        sectionId = section.id,
        distanceFromTop = 700.0,
        onViewportEntered = {
            if (breakpoint > Breakpoint.SM) {
                scope.launch {
                    while (titleMargin.value > 0) {
                        delay(10)
                        subtitleMargin = subtitleMargin - 10.px
                        delay(10)
                        titleMargin = titleMargin - 10.px
                    }
                }
            }
        }
    )

    Column(
        modifier = modifier,
        horizontalAlignment = alignment
    ) {
        P(
            attrs = Modifier
                .fillMaxWidth()
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                )
                .margin(
                    left = titleMargin,
                    top = 0.px,
                    bottom = 0.px
                )
                .fontFamily(FONT_FAMILY)
                .fontSize(25.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Primary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms))
                .toAttrs()
        ) {
            Text(section.title)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .textAlign(
                    when (alignment) {
                        Alignment.CenterHorizontally -> TextAlign.Center
                        Alignment.End -> TextAlign.End
                        else -> TextAlign.Start
                    }
                )
                .margin(
                    left = if (alignment == Alignment.Start) subtitleMargin else 0.px,
                    right = if (alignment == Alignment.CenterHorizontally) subtitleMargin else 0.px,
                    bottom = 10.px,
                    top = 0.px
                )
                .fontFamily(FONT_FAMILY)
                .fontSize(40.px)
                .fontWeight(FontWeight.Bold)
                .color(Theme.Secondary.rgb)
                .transition(Transition.of(property = "margin", duration = 300.ms))
                .toAttrs()
        ) {
            Text(section.subtitle)
        }
        section.text?.let { text ->
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(text)
            }
        }
        Box(
            modifier = Modifier
                .height(2.px)
                .width(80.px)
                .backgroundColor(Theme.Primary.rgb)
                .borderRadius(r = 50.px)
        )
    }
}