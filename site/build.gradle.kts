import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.belarussianin.personalpsychologistwebsite"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Powered by Kobweb")

            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("personalpsychologistwebsite", includeServer = true)

    sourceSets {
        commonMain.dependencies {
            // Add shared dependencies between JS and JVM here
            implementation(libs.compose.runtime)
        }
        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.compose)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.foundation)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            //implementation(project(":worker"))

            implementation("com.github.stevdza-san:KotlinBootstrap:0.1.5")
        }
        jvmMain.dependencies {
            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
        }
    }
}
