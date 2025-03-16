package com.belarussianin.personalpsychologistwebsite.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.NavigationItemStyle
import com.belarussianin.personalpsychologistwebsite.styles.SocialLinkStyle
import com.belarussianin.personalpsychologistwebsite.util.Constants.FONT_FAMILY
import com.belarussianin.personalpsychologistwebsite.util.Constants.HEADER_HEIGHT
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.navigation.UpdateHistoryMode
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegram
import com.varabyte.kobweb.silk.components.icons.fa.FaViber
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.breakpoint.displayUntil
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

class MobileMenuState(
    isOpen: Boolean,
    val breakpoint: Breakpoint,
    private val scope: CoroutineScope
) {
    var isOpen by mutableStateOf(isOpen)
        private set
    var translateX by mutableStateOf((100).percent)
        private set
    var opacity by mutableStateOf(0.percent)
        private set

    fun toggle() {
        if (isOpen) close() else open()
    }

    fun open() {
        scope.launch {
            isOpen = true
            delay(100)
            translateX = 0.percent
            opacity = 100.percent
        }
    }

    fun close() {
        scope.launch {
            translateX = 100.percent
            opacity = 0.percent
            delay(500)
            isOpen = false
        }
    }
}

@Composable
fun rememberMobileMenuState(
    isOpen: Boolean = false,
    breakpoint: Breakpoint = rememberBreakpoint(),
    scope: CoroutineScope = rememberCoroutineScope()
) = remember {
    MobileMenuState(isOpen, breakpoint, scope)
}

@Composable
fun MobileMenu(
    state: MobileMenuState,
    onMenuClose: () -> Unit
) {
    if (state.isOpen) {
        Row(
            modifier = Modifier
                .displayUntil(Breakpoint.MD)
                .top(0.px)
                .right(0.px)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .position(Position.Fixed)
                    .borderRadius(bottomLeft = 32.px)
                    .zIndex(2)
                    .opacity(state.opacity)
                    .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
                    .transition(Transition.of(property = "opacity", duration = 500.ms))
            ) {
                Column(
                    modifier = Modifier
                        .padding(all = 25.px)
                        .margin(top = HEADER_HEIGHT.px)
                        .width(100.percent)
                        .overflow(Overflow.Auto)
                        .borderRadius(bottomLeft = 32.px)
                        .boxShadow((-1).px, 1.px, 0.px, color = rgba(0, 0, 0, 0.1))
                        .scrollBehavior(ScrollBehavior.Smooth)
                        .backgroundColor(Theme.Primary.rgb)
                        .translateX(tx = state.translateX)
                        .transition(Transition.of(property = "translate", duration = 500.ms))
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
                        NavLink(
                            section = section,
                            onClick = { onMenuClose() }
                        )
                    }
                    NavLink(
                        section = Section.Contacts,
                        modifier = Modifier.displayUntil(Breakpoint.SM),
                        onClick = { onMenuClose() }
                    )

                    Row(
                        modifier = Modifier
                            .displayUntil(Breakpoint.SM)
                            .margin(top = 24.px)
                            .fillMaxWidth(30.percent),
                        horizontalArrangement = Arrangement.SpaceBetween,
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
                    }
                }
            }
        }
    }
}

@Composable
private fun NavLink(
    section: Section,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Link(
        modifier = NavigationItemStyle.toModifier().then(modifier)
            .margin(bottom = 24.px)
            .fontFamily(FONT_FAMILY)
            .fontWeight(FontWeight.Normal)
            .textDecorationLine(TextDecorationLine.None)
            .onClick { onClick() },
        path = section.path,
        text = section.title,
        updateHistoryMode = UpdateHistoryMode.REPLACE,
        openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
    )
}