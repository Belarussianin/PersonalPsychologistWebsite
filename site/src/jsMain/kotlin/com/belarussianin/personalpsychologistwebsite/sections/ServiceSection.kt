package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import com.belarussianin.personalpsychologistwebsite.components.SectionTitle
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Service
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.ServiceCardStyle
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.belarussianin.personalpsychologistwebsite.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceSection() {
    Box(
        modifier = Modifier
            .id(Section.Services.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(top = 80.px),
        contentAlignment = Alignment.Center
    ) {
        ServiceContent()
    }
}

@Composable
fun ServiceContent() {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxWidth(
                if (breakpoint >= Breakpoint.MD) 100.percent
                else 90.percent
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth()
                .margin(bottom = 20.px),
            section = Section.Services,
            alignment = Alignment.CenterHorizontally
        )
        SimpleGrid(numColumns = numColumns(base = 1, sm = 2, md = 3)) {
            Service.entries.forEach { service ->
                ServiceCard(service = service, breakpoint = breakpoint)
            }
        }
    }
}

@Composable
private fun ServiceCard(
    service: Service,
    breakpoint: Breakpoint
) {
    Row(
        modifier = ServiceCardStyle.toModifier()
            .maxWidth(300.px)
            .margin(all = 8.px)
            .padding(all = if (breakpoint > Breakpoint.SM) 16.px else 8.px)
            .gap(16.px),
    ) {
        Box(
            modifier = Modifier
                .id("iconBox")
                .minWidth(34.px)
                .padding(all = 8.px)
                .margin(bottom = 16.px)
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .borderRadius(
                    topLeft = 20.px,
                    topRight = 20.px,
                    bottomLeft = 20.px,
                    bottomRight = 0.px
                )
                .backgroundColor(Theme.Primary.rgb),
            contentAlignment = Alignment.Center
        ) {
            SpanText(
                text = service.title,
                modifier = Modifier.fontSize(24.px).color(Theme.Secondary.rgb)
            )
//            Image(
//                modifier = Modifier.size(40.px),
//                src = service.icon,
//                alt = service.imageDesc
//            )
        }
        P(
            attrs = Modifier
                .align(Alignment.CenterVertically)
                .fillMaxWidth()
                .margin(top = 0.px, bottom = 10.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(18.px)
                .fontWeight(FontWeight.Bold)
                .toAttrs()
        ) {
            Text(service.description)
        }
//        P(
//            attrs = Modifier
//                .fillMaxWidth()
//                .margin(top = 0.px, bottom = 0.px)
//                .fontFamily(FONT_FAMILY)
//                .fontSize(14.px)
//                .fontWeight(FontWeight.Normal)
//                .toAttrs()
//        ) {
//            Text(service.description)
//        }
    }
}