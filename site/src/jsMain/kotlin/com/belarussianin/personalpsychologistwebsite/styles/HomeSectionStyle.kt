package com.belarussianin.personalpsychologistwebsite.styles

import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.until
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val HomeSectionContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(leftRight = 48.px)
    }
    Breakpoint.ZERO {
        Modifier.padding(leftRight = 16.px)
    }
    Breakpoint.SM {
        Modifier.padding(leftRight = 10.percent)
    }
}

val HomeSectionHeadTextStyle = CssStyle {
    base {
        Modifier
            .fontFamily(FONT_FAMILY)
            .whiteSpace(WhiteSpace.NoWrap)
            .fontWeight(FontWeight.Bolder)
            .color(Theme.Secondary.rgb)
    }

    Breakpoint.ZERO { Modifier.fontSize(18.px) }
    Breakpoint.SM { Modifier.fontSize(18.px) }
    Breakpoint.MD { Modifier.fontSize(24.px) }
    Breakpoint.LG { Modifier.fontSize(32.px) }
    Breakpoint.XL { Modifier.fontSize(40.px) }
}

val HomeSectionButtonStyle = CssStyle {
    base {
        Modifier
            .width(280.px)
            .backgroundColor(Theme.PrimaryContainer.rgb)
            .transition(Transition.of(property = "width", duration = 200.ms))
    }
    until(Breakpoint.LG) {
        Modifier.maxWidth(280.px)
    }
    hover {
        Modifier.width(320.px)
    }
}

@OptIn(ExperimentalComposeWebApi::class)
val MainImageStyle = CssStyle {
    base {
        Modifier
//            .styleModifier {
//                filter { grayscale(100.percent) }
//            }
//            .transition(Transition.of(property = "filter", duration = 200.ms))
    }
    hover {
        Modifier
//            .styleModifier {
//                filter { grayscale(0.percent) }
//            }
    }
}