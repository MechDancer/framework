import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

version = "0.1.0-rc-1"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
}

task<Jar>("sourceJar") {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

tasks["jar"].dependsOn("sourceJar")