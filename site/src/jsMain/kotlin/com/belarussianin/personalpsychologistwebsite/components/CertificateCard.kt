package com.belarussianin.personalpsychologistwebsite.components

import androidx.compose.runtime.Composable
import com.belarussianin.personalpsychologistwebsite.models.Certificate
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun CertificateCard(
    modifier: Modifier = Modifier,
    certificate: Certificate
) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = modifier
            .minWidth(if (breakpoint > Breakpoint.ZERO) 400.px else 256.px)
            .cursor(Cursor.ZoomIn),
    ) {
        Image(
            modifier = Modifier
                .maxWidth(if (breakpoint > Breakpoint.ZERO) 400.px else 256.px)
                .margin(bottom = 20.px)
                .objectFit(ObjectFit.Contain),
            src = certificate.image,
            alt = "Certificate Image"
        )
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(certificate.title)
        }
        P(
            attrs = Modifier
                .fillMaxWidth()
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .fontWeight(FontWeight.Normal)
                .color(Theme.Secondary.rgb)
                .opacity(50.percent)
                .toAttrs()
        ) {
            Text(certificate.description)
        }
    }
}