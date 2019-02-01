import com.novoda.gradle.release.PublishExtension
import org.jetbrains.dokka.gradle.DokkaTask

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.1.0-rc-3"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    testImplementation("junit", "junit", "4.12")
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
    artifactId = "dependency"
    publishVersion = version.toString()
    desc = "dependency management for mechdancer framework"
    website = "https://github.com/MechDancer/framework/dependency"
    issueTracker = "https://github.com/MechDancer/framework/issues"
    repository = "https://github.com/MechDancer/framework.git"
    setLicences("WTFPL")
}
