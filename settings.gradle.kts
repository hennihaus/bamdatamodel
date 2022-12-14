pluginManagement {
    val kotlinVersion: String by settings
    val ktLintVersion: String by settings
    val koverVersion: String by settings
    val detektVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinVersion
        id("org.jlleitschuh.gradle.ktlint") version ktLintVersion
        id("org.jetbrains.kotlinx.kover") version koverVersion
        id("io.gitlab.arturbosch.detekt") version detektVersion
    }
}
