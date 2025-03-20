package com.belarussianin.personalpsychologistwebsite.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.belarussianin.personalpsychologistwebsite.components.SectionTitle
import com.belarussianin.personalpsychologistwebsite.models.Certificate
import com.belarussianin.personalpsychologistwebsite.models.Section
import com.belarussianin.personalpsychologistwebsite.models.Theme
import com.belarussianin.personalpsychologistwebsite.util.Constants.SECTION_WIDTH
import com.stevdza.san.kotlinbs.util.UniqueIdGenerator
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.cursor
import com.varabyte.kobweb.compose.css.objectFit
import com.varabyte.kobweb.compose.css.translateX
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.style.KobwebComposeStyleSheet.type
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.classNames
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

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
private fun AboutContent() {
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
        CertificatesCarousel(
            breakpoint = breakpoint,
            selectedCertificate = selectedCertificate,
            onCertificateSelected = { selectedCertificate = it }
        )
    }
}

@Composable
private fun CertificatesCarousel(
    breakpoint: Breakpoint,
    selectedCertificate: Certificate? = null,
    onCertificateSelected: (Certificate?) -> Unit
) {
    val randomId = remember {
        UniqueIdGenerator.generateUniqueId("carousel")
    }

    Column(
        modifier = Modifier
            .maxWidth(
                when {
                    selectedCertificate != null -> 2560.px
                    breakpoint > Breakpoint.SM -> 600.px
                    breakpoint > Breakpoint.ZERO -> 400.px
                    else -> 256.px
                }
            )
            .height(auto)
            .fillMaxSize()
            .padding(if (selectedCertificate == null) 2.cssRem else 0.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bootstrap Carousel
        Div(attrs = {
            classes("carousel", "slide")
            id(randomId) // Ensure unique ID
            //attr("data-bs-ride", "carousel")
            classes("carousel-dark")
        }) {
            // Carousel Inner
            Div(attrs = { classes("carousel-inner") }) {
                Certificate.entries.forEachIndexed { index, certificate ->
                    Div(attrs = {
                        classes("carousel-item")
                        if (index == 0) classes("active")  // First item active
                    }) {
                        Img(
                            src = certificate.image,
                            attrs = {
                                classes("d-block", "w-100")
                                onClick {
                                    onCertificateSelected(if (selectedCertificate != null) null else certificate)
                                }
                                style {
                                    objectFit(ObjectFit.Cover)
                                    cursor(if (selectedCertificate != null) Cursor.ZoomOut else Cursor.ZoomIn)  // Show it's clickable
                                }
                            }
                        )
                    }
                }

                // Controls (Previous)
                Button(
                    attrs = {
                        classes("carousel-control-prev")
                        type(ButtonType.Button.str)
                        attr("data-bs-target", "#$randomId")
                        attr("data-bs-slide", "prev")
                        style { translateX((-40).px) }
                    }
                ) {
                    Span(
                        attrs = {
                            classes("carousel-control-prev-icon")
                            style { translateX(16.px) }
                        }
                    )
                    Span(attrs = { classes("visually-hidden") }) { Text("Previous") }
                }

                // Controls (Next)
                Button(
                    attrs = {
                        classes("carousel-control-next")
                        type(ButtonType.Button.str)
                        attr("data-bs-target", "#$randomId")
                        attr("data-bs-slide", "next")
                        style { translateX(40.px) }
                    }
                ) {
                    Span(
                        attrs = {
                            classes("carousel-control-next-icon")
                            style { translateX((-16).px) }
                        }
                    )
                    Span(attrs = { classes("visually-hidden") }) { Text("Next") }
                }
            }
            //Carousel indicators
            Div(
                attrs = Modifier
                    .classNames("carousel-indicators")
                    .translateY(40.px)
                    .toAttrs()
            ) {
                Certificate.entries.forEachIndexed { index, certificate ->
                    Button(attrs = Modifier
                        .thenIf(
                            condition = certificate == Certificate.entries.first(),
                            other = Modifier.classNames("active")
                        )
                        .thenIf(
                            condition = certificate == Certificate.entries.first(),
                            other = Modifier.attrsModifier {
                                attr("aria-current", "true")
                            }
                        )
                        .size(width = 32.px, height = 8.px)
                        .backgroundColor(Theme.Primary.rgb)
                        .toAttrs {
                            attr("data-bs-target", "#$randomId")
                            attr("data-bs-slide-to", "$index")
                            attr("data-bs-slide-to", "$index")
                            attr("aria-label", "Slide $index")
                        }
                    )
                }
            }
        }
    }
}