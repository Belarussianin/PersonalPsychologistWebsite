package com.belarussianin.personalpsychologistwebsite.models

import com.varabyte.kobweb.compose.ui.graphics.Color
import org.jetbrains.compose.web.css.CSSColorValue

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#dfc56d", rgb = Color.rgb(223, 197, 109)),
    OnPrimary(hex = "#ffffff", rgb = Color.rgb(255, 255, 255)),
    PrimaryContainer(hex = "#fce186", rgb = Color.rgb(252, 225, 134)),
    Secondary(hex = "#121D34", rgb = Color.rgb(103, 94, 64)),
    OnSecondary(hex = "#ffffff", rgb = Color.rgb(255, 255, 255)),
    SecondaryContainer(hex = "#f0e2bb", rgb = Color.rgb(240, 226, 187)),
    Surface(hex = "#fff8ef", rgb = Color.rgb(255, 248, 239)),
    OnSurface(hex = "#1e1b13", rgb = Color.rgb(30, 27, 19)),
    Tertiary(hex = "#45664c", rgb = Color.rgb(69, 102, 76))
}