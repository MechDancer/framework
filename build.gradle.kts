import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.9.17")
        classpath("com.novoda:bintray-release:+")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.20")
    }
}

version = "v1.1.1"

task<Delete>("clean") {
    group = "build"
    delete(rootProject.buildDir)
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

    task<Jar>("javadocJar") {
        group = "build"
        classifier = "javadoc"
        from("$buildDir/javadoc")
    }

    task<Copy>("copyArtifacts") {
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
