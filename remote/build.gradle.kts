import com.novoda.gradle.release.PublishExtension

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.2.1-dev-11"

dependencies {
    api(kotlin("stdlib"))
    api(kotlin("reflect"))

    api("org.slf4j:slf4j-api:1.8.0-beta2")     // 日志接口层
    api("org.slf4j:slf4j-log4j12:1.8.0-beta2") // 适配器
    api("log4j:log4j:1.2.17")                  // 本体

    api(project(":dependency"))
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
