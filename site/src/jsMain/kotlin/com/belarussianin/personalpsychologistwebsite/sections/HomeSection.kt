package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.HomeSectionButtonStyle
import com.belarussianin.personalpsychologistwebsite.styles.HomeSectionContentStyle
import com.belarussianin.personalpsychologistwebsite.styles.HomeSectionHeadTextStyle
import com.belarussianin.personalpsychologistwebsite.styles.MainImageStyle
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.belarussianin.personalpsychologistwebsite.util.Constants.HEADER_HEIGHT
import com.belarussianin.personalpsychologistwebsite.util.Constants.SECTION_WIDTH
import com.belarussianin.personalpsychologistwebsite.util.Res
import com.varabyte.kobweb.compose.css.CSSTextShadow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onTouchEnd
import com.varabyte.kobweb.compose.ui.modifiers.onTouchStart
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.textShadow
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun HomeSection(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .margin(top = HEADER_HEIGHT.px)
            .maxWidth(SECTION_WIDTH.px)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HomeBackground()
        HomeContent()
    }
}

@Composable
fun HomeBackground() {
    Image(
        modifier = Modifier
            .maxHeight(800.px)
            .fillMaxHeight()
            .width(100.percent)
            .objectFit(ObjectFit.Cover),
        src = Res.Image.background,
        alt = "Background Image"
    )
}

@Composable
fun HomeContent() {
    val breakpoint = rememberBreakpoint()
    SimpleGrid(
        modifier = HomeSectionContentStyle.toModifier(),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        HomeText(breakpoint = breakpoint)
        HomeImage()
    }
}

@Composable
fun HomeText(breakpoint: Breakpoint) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            P(
                attrs = HomeSectionHeadTextStyle.toModifier()
                    .margin(top = 20.px, bottom = 0.px)
                    .toAttrs()
            ) {
                Text(Res.String.home_section_head_start_text)
            }
            Column(
                modifier = Modifier.margin(left = if (breakpoint >= Breakpoint.LG) 112.px else 48.px)
            ) {
                P(
                    attrs = HomeSectionHeadTextStyle.toModifier()
                        .margin(top = 0.px, bottom = 16.px)
                        .toAttrs()
                ) {
                    Text(Res.String.home_section_head_end_text)
                }
                P(
                    attrs = Modifier
                        .margin(bottom = 25.px)
                        .maxWidth(420.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontStyle(FontStyle.Italic)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
                ) {
                    Text(Res.String.home_section_body_text)
                }
                var blurRadius by remember { mutableStateOf(3.px) }
                Button(
                    attrs = HomeSectionButtonStyle.toModifier()
                        .height(40.px)
                        .borderRadius(16.px)
                        .boxShadow(blurRadius = blurRadius, color = Color.white)
                        .border(0.px)
                        .textShadow(CSSTextShadow(0.px, 1.px, 3.px, color = Colors.White))
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    Link(
                        modifier = Modifier
                            .fontSize(18.px)
                            .color(Theme.Secondary.rgb)
                            .onTouchStart { blurRadius = 16.px }
                            .onTouchEnd { blurRadius = 3.px }
                            .textDecorationLine(TextDecorationLine.None),
                        text = Res.String.home_section_button_text,
                        path = Section.Contacts.path
                    )
                }
            }
        }
    }
}

@Composable
fun HomeImage() {
    Column(
        modifier = Modifier.fillMaxSize().fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Image(
            modifier = MainImageStyle.toModifier().fillMaxWidth(),
            src = Res.Image.main,
            alt = "Main Image"
        )
    }
}