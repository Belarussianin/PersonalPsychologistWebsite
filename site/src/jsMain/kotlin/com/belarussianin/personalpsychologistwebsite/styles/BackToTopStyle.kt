package com.belarussianin.personalpsychologistwebsite.styles

import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.until
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier
            .bottom(0.px)
            .right(0.px)
            .position(Position.Fixed)
            .size(80.px)
            .borderRadius(20.percent)
            .margin(right = 40.px, bottom = 40.px)
            .backgroundColor(Theme.Primary.rgb)
            .cursor(Cursor.Pointer)
            .styleModifier {
                property("pointer-events", "auto")
            }
    }
    Breakpoint.ZERO { Modifier.size(40.px) }
    Breakpoint.SM { Modifier.size(56.px) }

    until(Breakpoint.MD) {
        Modifier.margin(right = 30.px, bottom = 30.px)
    }

    Breakpoint.MD { Modifier.size(72.px) }
}