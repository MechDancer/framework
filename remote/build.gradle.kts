import com.novoda.gradle.release.PublishExtension

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.2.1-dev-11"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    compile(project(":dependency"))
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(sourceSets["main"].allSource)
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
