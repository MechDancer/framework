import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

version = "0.2.1-dev-5"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    compile(project(":dependency"))
}

task<Jar>("sourceJar") {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

tasks["jar"].dependsOn("sourceJar")
