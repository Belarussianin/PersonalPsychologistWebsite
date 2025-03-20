package com.belarussianin.personalpsychologistwebsite.styles

import com.belarussianin.personalpsychologistwebsite.util.hexToRGBA
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val ContactsStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(topBottom = 48.px)
            .position(Position.Relative)
    }
}

val ContactsLinkStyle = CssStyle {
    base {
        Modifier
            .color(hexToRGBA("#1F4B5B"))
            .textDecorationLine(TextDecorationLine.None)
            .transition(Transition.of(property = "color", duration = 300.ms))
    }

    hover {
        Modifier.color(hexToRGBA("#C17D63"))
    }
}

val ContactsSocialIconStyle = CssStyle {
    base {
        Modifier
            .padding(8.px)
            .backgroundColor(hexToRGBA("#C17D63"))
            .borderRadius(50.percent)
            .color(Colors.White)
            .cursor(Cursor.Pointer)
            .transition(Transition.of(property = "background-color", duration = 300.ms))
    }

    hover {
        Modifier.backgroundColor(hexToRGBA("#A66B53"))
    }
}

val ContactsButtonStyle = CssStyle {
    base {
        Modifier
            .backgroundColor(hexToRGBA("#C17D63"))
            .color(Colors.White)
            .borderRadius(4.px)
            .padding(12.px, 24.px)
            .cursor(Cursor.Pointer)
            .border(0.px)
            .fontSize(16.px)
            .transition(Transition.of(property = "background-color", duration = 300.ms))

    }

    hover {
        Modifier.backgroundColor(hexToRGBA("#A66B53"))
    }
}