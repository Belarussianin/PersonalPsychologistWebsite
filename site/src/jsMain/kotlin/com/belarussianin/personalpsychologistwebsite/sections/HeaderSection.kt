package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.LogoStyle
import com.belarussianin.personalpsychologistwebsite.styles.NameStyle
import com.belarussianin.personalpsychologistwebsite.styles.NavigationItemStyle
import com.belarussianin.personalpsychologistwebsite.styles.SocialLinkStyle
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.belarussianin.personalpsychologistwebsite.util.Constants.HEADER_HEIGHT
import com.belarussianin.personalpsychologistwebsite.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.icons.fa.FaViber
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Text

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier.zIndex(Int.MAX_VALUE - 1),
    onMenuClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(HEADER_HEIGHT.px)
            .backgroundColor(Theme.Primary.rgb)
            .boxShadow(0.px, 1.px, 0.px, color = rgba(0, 0, 0, 0.1))
            .position(Position.Fixed)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide()
        CenterSide(
            modifier = Modifier.displayIfAtLeast(Breakpoint.MD)
        )
        RightSide(onMenuClicked = onMenuClicked)
    }
}

@Composable
private fun LeftSide() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = LogoStyle.toModifier()
                .size(HEADER_HEIGHT.px),
            src = Res.Image.logo,
            alt = "Logo Image"
        )
        Link(
            path = Section.Home.path,
            modifier = NameStyle.toModifier()
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontWeight(FontWeight.Normal)
                //.color(Theme.Secondary.rgb)
                .textDecorationLine(TextDecorationLine.None),
            updateHistoryMode = UpdateHistoryMode.REPLACE,
            openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
        ) {
            Text("Лариса Ворса")
        }
    }
}

@Composable
private fun CenterSide(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.margin(left = 24.px)
    ) {
        val links = remember {
            arrayOf(
                //Section.Home,
                /** Section.Blog */
                Section.Services,
                Section.Reviews,
                Section.About
            )
        }
        links.forEach { section ->
            /**
            if (section is Section.Blog) {
            NavLink(section, updateHistoryMode = null)
            }
             */
            NavLink(section)
        }
    }
}

@Composable
private fun RightSide(
    onMenuClicked: () -> Unit
) {
    Row(
        modifier = Modifier.gap(10.px),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .displayIfAtLeast(Breakpoint.SM)
                .gap(10.px),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Link(
                path = "viber://chat?number=%2B375291925218",
                modifier = Modifier.size(30.px)
            ) {
                FaViber(
                    modifier = SocialLinkStyle.toModifier(),
                    size = IconSize.X2
                )
            }

            Link(
                path = "https://t.me/+375291925218",
                modifier = Modifier.size(30.px)
            ) {
                FaTelegram(
                    modifier = SocialLinkStyle.toModifier(),
                    size = IconSize.X2
                )
            }

            NavLink(
                modifier = Modifier.padding(leftRight = 15.px),
                section = Section.Contacts
            )
        }

        Box(
            modifier = Modifier
                .displayUntil(Breakpoint.MD)
                .margin(leftRight = 8.px),
            contentAlignment = Alignment.CenterEnd
        ) {
            FaBars(
                modifier = Modifier
                    .color(Theme.Secondary.rgb)
                    .onClick {
                        onMenuClicked()
                    },
                size = IconSize.XL
            )
        }
    }
}

@Composable
private fun NavLink(
    section: Section,
    modifier: Modifier = Modifier,
    updateHistoryMode: UpdateHistoryMode? = UpdateHistoryMode.REPLACE
) {
    Link(
        modifier = NavigationItemStyle.toModifier()
            .padding(right = 24.px)
            .fontFamily(FONT_FAMILY)
            .fontWeight(FontWeight.Normal)
            .textDecorationLine(TextDecorationLine.None)
            .then(modifier),
        path = section.path,
        text = section.title,
        updateHistoryMode = updateHistoryMode,
        openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
    )
}