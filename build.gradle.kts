import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50" apply (false)
    id("org.jetbrains.dokka") version "0.9.18" apply (false)
    id("com.jfrog.bintray") version "1.8.4" apply (false)
    `build-scan`
}

version = "v1.2.0"

tasks.register<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
}

tasks.register<DokkaTask>("website") {
    outputFormat = "jekyll"
    sourceDirs =
        rootProject.subprojects
            .filter { it !== project }
            .map { file("${it.projectDir}/src/main/kotlin") }
    outputDirectory = "$rootDir/docs"
    finalizedBy("createJekyllConfig")
}

tasks.register("createJekyllConfig") {
    group = "documentation"
    doLast {
        File("$rootDir/docs/_config.yml")
            .also { it.createNewFile() }
            .appendText("theme: jekyll-theme-hacker")
    }
}

subprojects {
    group = "org.mechdancer"
    repositories {
        mavenCentral()
        jcenter()
    }

    apply {
        plugin("org.jetbrains.dokka")
        plugin("kotlin")
        plugin("java")
        plugin("com.jfrog.bintray")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.register<Jar>("javadocJar") {
        group = "build"
        archiveClassifier.set("javadoc")
        from("$buildDir/javadoc")
        dependsOn("dokka")
    }

    tasks.register<Copy>("copyArtifacts") {
        group = "build"
        from("$buildDir/libs")
        into("${rootProject.buildDir}/libs")
    }


    tasks.withType<DokkaTask> {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/javadoc"
    }

    tasks["javadoc"].dependsOn("dokka")
    tasks["jar"].dependsOn("sourcesJar")
    tasks["jar"].dependsOn("javadocJar")
    tasks["jar"].finalizedBy("copyArtifacts")
}
