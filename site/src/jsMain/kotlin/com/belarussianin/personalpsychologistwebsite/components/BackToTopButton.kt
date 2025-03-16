package com.belarussianin.personalpsychologistwebsite.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.BackToTopButtonStyle
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.document
import kotlinx.browser.window

@Composable
fun BackToTopButton() {
    var scroll: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }

    Box(
        modifier = BackToTopButtonStyle.toModifier()
            .zIndex(1)
            .visibility(
                if (scroll != null && scroll!! > 400.0) Visibility.Visible
                else Visibility.Hidden
            )
            .onClick {
                document.documentElement?.scroll(x = 0.0, y = 0.0)
            },
        contentAlignment = Alignment.Center
    ) {
        FaArrowUp(
            modifier = Modifier.color(Theme.Secondary.rgb),
            size = IconSize.XL
        )
    }
}