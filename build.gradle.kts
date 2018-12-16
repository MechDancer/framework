import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.11"
}

allprojects{
    group = "org.mechdancer"
    repositories {
        mavenCentral()
    }
}

dependencies {
    subprojects.forEach { archives(it) }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}