import kotlinx.kover.api.CounterType
import kotlinx.kover.api.DefaultIntellijEngine
import kotlinx.kover.api.VerificationValueType

plugins {
    kotlin("jvm")
    id("java-library")
    id("maven-publish")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.jetbrains.kotlinx.kover")
    id("io.gitlab.arturbosch.detekt")
}

group = "de.hennihaus"
version = System.getenv("DATA_MODEL_VERSION") ?: "1.0.0"

java {
    withSourcesJar()
}

repositories {
    mavenCentral()
}

configurations.all {
    // exclude kotlin test libraries
    exclude("org.jetbrains.kotlin", "kotlin-test")
    exclude("org.jetbrains.kotlin", "kotlin-test-common")
    exclude("org.jetbrains.kotlin", "kotlin-test-annotations-common")
    exclude("org.jetbrains.kotlin", "kotlin-test-junit")
}

dependencies {
    val jacksonVersion: String by project
    val kotestVersion: String by project
    val mockkVersion: String by project
    val junitVersion: String by project

    // productive plugins

    // test plugins
    testImplementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-json-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property-jvm:$kotestVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

ktlint {
    ignoreFailures.set(false)
    baseline.set(file("config/ktlint/baseline.xml"))
}

detekt {
    config = files("config/detekt/detekt.yml")
    baseline = file("config/detekt/detekt-baseline.xml")
}

kover {
    engine.set(DefaultIntellijEngine)
}

koverMerged {
    enable()
    xmlReport {
        onCheck.set(true)
    }
    htmlReport {
        onCheck.set(true)
    }
    verify {
        onCheck.set(true)
        rule {
            bound {
                val minTestCoverageInPercent: String by project
                minValue = minTestCoverageInPercent.toInt()
                counter = CounterType.LINE
                valueType = VerificationValueType.COVERED_PERCENTAGE
            }
        }
    }
}

val packageObjectMothers by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    include("de/hennihaus/bamdatamodel/objectmothers/*")
    from(sourceSets.test.get().output)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/hennihaus/bamdatamodel")
            credentials {
                username = "hennihaus"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("bamdatamodel") {
            artifactId = "bamdatamodel"
            artifact(packageObjectMothers)
            from(components["java"])
        }
    }
}

tasks.init {
    dependsOn(tasks.ktlintApplyToIdea)
}

tasks.test {
    useJUnitPlatform()
}

tasks.assemble {
    dependsOn(packageObjectMothers)
}
