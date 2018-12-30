import com.novoda.gradle.release.PublishExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.1.0-rc-1"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
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