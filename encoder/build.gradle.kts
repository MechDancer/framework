import com.novoda.gradle.release.PublishExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.0.1-dev-3"

dependencies {
    compile(kotlin("stdlib"))
    testCompile("junit", "junit", "+")
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}

configure<PublishExtension> {
    userOrg = "mechdancer"
    groupId = "org.mechdancer"
    artifactId = "encoder"
    publishVersion = version.toString()
    desc = "simple data encoder"
    website = "https://github.com/MechDancer/framework/encoder"
    issueTracker = "https://github.com/MechDancer/framework/issues"
    repository = "https://github.com/MechDancer/framework.git"
    setLicences("WTFPL")
}