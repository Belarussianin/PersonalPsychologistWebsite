package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.components.CertificateCard
import com.belarussianin.personalpsychologistwebsite.components.SectionTitle
import com.belarussianin.personalpsychologistwebsite.models.Certificate
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.styles.AboutSectionCertificatesArrowIconStyle
import com.belarussianin.personalpsychologistwebsite.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.ScrollBehavior
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.scrollBehavior
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun AboutSection() {
    Box(
        modifier = Modifier
            .id(Section.About.id)
            .maxWidth(SECTION_WIDTH.px)
            .padding(topBottom = 80.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent() {
    val breakpoint = rememberBreakpoint()
    var selectedCertificate by remember { mutableStateOf<Certificate?>(null) }

    Column(
        modifier = Modifier.fillMaxWidth(if (selectedCertificate == null) 90.percent else 100.percent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(
            modifier = Modifier
                .fillMaxWidth(90.percent)
                .margin(bottom = 25.px),
            section = Section.About,
            breakpoint = breakpoint
        )
        PortfolioCards(
            breakpoint = breakpoint,
            selectedCertificate = selectedCertificate,
            onCertificateSelected = { selectedCertificate = it }
        )
        PortfolioNavigation(
            breakpoint = breakpoint,
            isVisible = selectedCertificate == null
        )
    }
}

@Composable
fun PortfolioCards(
    breakpoint: Breakpoint,
    selectedCertificate: Certificate? = null,
    onCertificateSelected: (Certificate?) -> Unit
) {
    Row(
        modifier = Modifier
            .id("scrollableContainer")
            .fillMaxWidth()
            .gap(25.px)
            .margin(bottom = 25.px)
            .maxWidth(
                when {
                    selectedCertificate != null -> 2560.px
                    breakpoint > Breakpoint.LG -> 1250.px
                    breakpoint > Breakpoint.MD -> 825.px
                    breakpoint > Breakpoint.ZERO -> 400.px
                    else -> 256.px
                }
            )
            .height(auto)
            .overflow(Overflow.Hidden)
            .scrollBehavior(ScrollBehavior.Smooth),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (selectedCertificate) {
            null -> {
                Certificate.entries.forEach { certificate ->
                    CertificateCard(
                        modifier = Modifier.onClick { onCertificateSelected(certificate) },
                        certificate = certificate
                    )
                }
            }

            else -> { // Modal Section (Zoomed Image)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .cursor(Cursor.ZoomOut)
                        .onClick { onCertificateSelected(null) }
                ) {
                    Image(src = selectedCertificate.image, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun PortfolioNavigation(
    breakpoint: Breakpoint,
    isVisible: Boolean = true,
    itemsCount: Int = Certificate.entries.size
) {
    val scope = rememberCoroutineScope()

    val visibleCount by remember(breakpoint) {
        mutableStateOf(
            when {
                breakpoint > Breakpoint.LG -> 3
                breakpoint > Breakpoint.MD -> 2
                else -> 1
            }
        )
    }

    var selectedIndex by remember { mutableStateOf(0) }

    val extraPageSize = remember(visibleCount) {
        derivedStateOf {
            itemsCount % visibleCount
        }
    }

    val totalPages = remember(extraPageSize, visibleCount) {
        derivedStateOf {
            itemsCount / visibleCount + if (extraPageSize.value > 0) 1 else 0
        }
    }

    suspend fun navigate(index: Int) {
        val indexOfFirstItemOnLastPage = (totalPages.value - 1) * visibleCount
        val missingItemsOnLastPage = totalPages.value * visibleCount - itemsCount

        when {
            index == selectedIndex -> return
            index < 0 -> return navigate(0)
            index > indexOfFirstItemOnLastPage -> return navigate(indexOfFirstItemOnLastPage)
        }

        val widthOfItem = if (breakpoint > Breakpoint.ZERO) 425.0 else 281.0

        val offsetX = when {
            index > selectedIndex -> index - selectedIndex
            selectedIndex == indexOfFirstItemOnLastPage && index < selectedIndex -> (selectedIndex - index - missingItemsOnLastPage) * -1
            index < selectedIndex -> (selectedIndex - index) * -1
            else -> 0
        } * widthOfItem

        document.getElementById("scrollableContainer")?.scrollBy(x = offsetX, y = 0.0)
        selectedIndex = index
    }

    LaunchedEffect(breakpoint) {
        navigate(0)
    }

    LaunchedEffect(isVisible) {
        if (isVisible) {
            val previousSelectedIndex = selectedIndex
            selectedIndex = 0
            navigate(previousSelectedIndex / visibleCount * visibleCount)
        }
    }

    if (isVisible) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterEnd
            ) {
                FaArrowLeft(
                    modifier = AboutSectionCertificatesArrowIconStyle.toModifier()
                        .cursor(Cursor.Pointer)
                        .onClick {
                            scope.launch {
                                navigate(selectedIndex - visibleCount)
                            }
                        },
                    size = IconSize.LG
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(totalPages.value) { indicatorIndex ->
                    Box(
                        modifier = Modifier
                            .margin(right = 10.px)
                            .cursor(Cursor.Pointer)
                            .size(12.px)
                            .borderRadius(50.px)
                            .backgroundColor(
                                if (indicatorIndex == selectedIndex / visibleCount) Theme.Primary.rgb
                                else Theme.PrimaryContainer.rgb
                            )
                            .onClick {
                                scope.launch {
                                    navigate(indicatorIndex * visibleCount)
                                }
                            }
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                FaArrowRight(
                    modifier = AboutSectionCertificatesArrowIconStyle.toModifier()
                        .cursor(Cursor.Pointer)
                        .onClick {
                            scope.launch {
                                navigate(selectedIndex + visibleCount)
                            }
                        },
                    size = IconSize.LG
                )
            }
        }
    }
}