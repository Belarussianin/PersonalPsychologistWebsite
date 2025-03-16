package com.belarussianin.personalpsychologistwebsite.styles

import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.until
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val LogoStyle = CssStyle {
    base {
        Modifier
            .transform { rotate(0.deg) }
            .transition(Transition.of(property = "transform", duration = 200.ms))
    }
    hover {
        Modifier.transform { rotate((-10).deg) }
    }
}

val NameStyle = CssStyle {
    until(Breakpoint.LG) {
        Modifier.fontSize(18.px)
    }

    Breakpoint.LG {
        Modifier.fontSize(24.px)
    }

    Breakpoint.XL {
        Modifier.fontSize(32.px)
    }
}

val NavigationItemStyle = CssStyle {
    base {
        Modifier
            .fontSize(24.px)
            .styleModifier {
                property("--bs-link-color", Theme.Secondary.rgb)
            }
            .color(Theme.Secondary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }

    hover {
        Modifier
            .styleModifier {
                property("--bs-link-hover-color", Theme.OnSecondary.rgb)
            }
            .color(Theme.OnSecondary.rgb)
    }

    until(Breakpoint.LG) {
        Modifier.fontSize(18.px)
    }
}

val SocialLinkStyle = CssStyle {
    base {
        Modifier
            .color(Theme.Secondary.rgb)
            .transition(Transition.of(property = "color", duration = 200.ms))
    }
    hover {
        Modifier.color(Theme.OnSecondary.rgb)
    }
}

val MenuButtonStyle = CssStyle {
    base {
        Modifier
            .width(100.px)
            .transition(Transition.of(property = "width", duration = 200.ms))
    }
    hover {
        Modifier.width(120.px)
    }
}