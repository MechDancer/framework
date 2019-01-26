import com.novoda.gradle.release.PublishExtension

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.0.1-dev-4"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    testCompile("junit", "junit", "4.12")
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(sourceSets["main"].allSource)
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
