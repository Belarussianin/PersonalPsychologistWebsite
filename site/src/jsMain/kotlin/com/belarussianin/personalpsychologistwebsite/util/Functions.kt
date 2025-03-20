package com.belarussianin.personalpsychologistwebsite.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgba
import org.w3c.dom.events.EventListener

fun hexToRGBA(hexString: String, opacity: Double = 1.0): CSSColorValue {
    val hex = hexString.replace("#", "")

    // Ensure hex string is in the correct format
    require(hex.length in listOf(3, 6, 8)) { "Invalid hex string length" }

    // Convert short hex to long format
    val fullHex = when (hex.length) {
        3 -> "${hex[0]}${hex[0]}${hex[1]}${hex[1]}${hex[2]}${hex[2]}"
        else -> hex
    }

    // Parse hex string into RGB components
    val r = fullHex.substring(0, 2).toInt(16)
    val g = fullHex.substring(2, 4).toInt(16)
    val b = fullHex.substring(4, 6).toInt(16)

    // If alpha is specified, parse it; otherwise, assume fully opaque
    val a = if (fullHex.length == 8) fullHex.substring(6, 8).toInt(16) / 255.0 else opacity

    return rgba(r, g, b, a)
}

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
) {
    var viewportEntered by remember { mutableStateOf(false) }
    val listener = remember {
        EventListener {
            val top = document.getElementById(sectionId)?.getBoundingClientRect()?.top
            if (top != null && top < distanceFromTop) {
                viewportEntered = true
            }
        }
    }

    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewportEntered()
            window.removeEventListener(type = "scroll", callback = listener)
        } else {
            window.addEventListener(type = "scroll", callback = listener)
        }
    }
}

suspend fun animateNumbers(
    number: Int,
    delay: Long = 10L,
    onUpdate: (Int) -> Unit
) {
    (0..number).forEach {
        delay(delay)
        onUpdate(it)
    }
}