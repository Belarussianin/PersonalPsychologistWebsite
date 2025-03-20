package com.belarussianin.personalpsychologistwebsite.pages

import androidx.compose.runtime.Composable
import com.belarussianin.personalpsychologistwebsite.components.MobileMenu
import com.belarussianin.personalpsychologistwebsite.components.rememberMobileMenuState
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.sections.AboutSection
import com.belarussianin.personalpsychologistwebsite.sections.ContactsSection
import com.belarussianin.personalpsychologistwebsite.sections.FooterSection
import com.belarussianin.personalpsychologistwebsite.sections.HeaderSection
import com.belarussianin.personalpsychologistwebsite.sections.HomeSection
import com.belarussianin.personalpsychologistwebsite.sections.ServiceSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Box(
        modifier = Modifier
            .zIndex(2)
            .id(Section.Home.id)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val menuState = rememberMobileMenuState(false)
            MobileMenu(
                state = menuState,
                onMenuClose = { menuState.close() }
            )

            HeaderSection(
                onMenuClicked = {
                    menuState.toggle()
                }
            )

            HomeSection()
            ServiceSection()
            AboutSection()

            ContactsSection()
            FooterSection()
        }
    }
}

//@Page
//@Composable
//fun HomePage() {
//    var menuOpened by remember { mutableStateOf(false) }
//    Column(modifier = Modifier.fillMaxSize()) {
//        HeaderSection()
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            MainSection(onMenuClicked = { menuOpened = true })
//            AboutSection()
//            ServiceSection()
//            PortfolioSection()
//            AchievementsSection()
//            TestimonialSection()
//            ExperienceSection()
//            ContactSection()
//            FooterSection()
//        }
//        BackToTopButton()
//        if (menuOpened) {
//            OverflowMenu(onMenuClosed = { menuOpened = false })
//        }
//    }
//}