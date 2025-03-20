package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.ContactsLinkStyle
import com.belarussianin.personalpsychologistwebsite.util.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Text

@Composable
fun FooterSection() {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .minHeight(56.px)
            .padding(leftRight = 10.percent, topBottom = 1.percent)
            .backgroundColor(Theme.Primary.rgb)
            .boxShadow(0.px, 1.px, 0.px, color = rgba(0, 0, 0, 0.1)),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        LeftSide(breakpoint)
        RightSide(breakpoint)
    }
}

@Composable
private fun LeftSide(breakpoint: Breakpoint) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart
    ) {
        Link(
            path = Res.String.FooterSection.copyright_path,
            modifier = ContactsLinkStyle.toModifier()
                .fontSize(14.px)
                .color(rgb(128, 128, 128))
        ) {
            Text(Res.String.FooterSection.copyright_text)
        }
    }
}

@Composable
private fun RightSide(breakpoint: Breakpoint) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Link(
            path = Res.String.FooterSection.developer_path,
            modifier = ContactsLinkStyle.toModifier()
                .thenIf(breakpoint > Breakpoint.ZERO, Modifier.textAlign(TextAlign.End))
                .fontSize(14.px)
                .color(rgb(128, 128, 128))
        ) {
            Text(Res.String.FooterSection.developer_text)
        }
    }
}