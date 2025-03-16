package com.belarussianin.personalpsychologistwebsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.style.breakpoint.BreakpointSizes
import com.varabyte.kobweb.silk.style.common.SmoothColorStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

@InitSilk
fun updateTheme(context: InitSilkContext) {
    context.theme.breakpoints = BreakpointSizes(
        sm = 30.cssRem,
        md = 48.cssRem,
        lg = 62.cssRem,
        xl = 88.cssRem,
    )
//    with(context.stylesheet) {
//        registerStyleBase("body") {
//            Modifier
//                .fontFamily("system-ui", "Segoe UI", "Tahoma", "Helvetica", "sans-serif")
//                .scrollBehavior(ScrollBehavior.Smooth)
//        }
//        registerStyle("h1") {
//            base {
//                Modifier
//                    .fontSize(2.5.cssRem)
//                    .marginBlock(0.5.cssRem, 0.5.cssRem)
//            }
//            Breakpoint.MD {
//                Modifier.fontSize(2.75.cssRem)
//            }
//        }
//        registerStyleBase("h2") {
//            Modifier.marginBlock(0.cssRem, 0.cssRem)
//        }
//    }
//
//    // https://coolors.co/1e1f22-3f334d-8bdbe2-f97068-f7e733
//    // todo: unique color modes
//    context.theme.palettes.light.apply {
//        background = Color.rgb(188, 190, 196)
//        color = Color.rgb(30, 31, 34)
//        button.set(
//            default = Color.rgb(0x545479),
//            hover = Color.rgb(0x545479).darkened(0.2f),
//            focus = context.theme.palettes.light.button.focus,
//            pressed = Color.rgb(0x545479).darkened(0.2f),
//        )
//    }
}

@App
@Composable
fun AppEntry(content: @Composable () -> Unit) {
    SilkApp {
        Surface(SmoothColorStyle.toModifier().minHeight(100.vh)) {
            content()
        }
    }
}
