import com.novoda.gradle.release.PublishExtension
import org.jetbrains.dokka.gradle.DokkaTask

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.2.1-dev-12"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.slf4j:slf4j-api:1.8.0-beta2")
    implementation(project(":dependency"))

    testImplementation("org.mechdancer:common-extension-log4j:v0.1.0")
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(sourceSets["main"].allSource)
}

task<DokkaTask>("website") {
    outputFormat = "jekyll"
    outputDirectory = "$rootDir/docs"
}


configure<PublishExtension> {
    userOrg = "mechdancer"
    groupId = "org.mechdancer"
    artifactId = "remote"
    publishVersion = version.toString()
    desc = "communication lib"
    website = "https://github.com/MechDancer/framework/remote"
    issueTracker = "https://github.com/MechDancer/framework/issues"
    repository = "https://github.com/MechDancer/framework.git"
    setLicences("WTFPL")
}
