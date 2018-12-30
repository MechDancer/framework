import com.novoda.gradle.release.PublishExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


apply {
    plugin("com.novoda.bintray-release")
}

version = "0.2.1-dev-5"

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    compile(project(":dependency"))
}

task<Jar>("sourcesJar") {
    classifier = "sources"
    from(java.sourceSets["main"].allSource)
}


configure<PublishExtension> {
    userOrg = "mechdancer"
    groupId = "org.mechdancer"
    artifactId = "remote"
    publishVersion = version.toString()
    desc = "communication lib"
    website = "https://github.com/MechDancer/framework/remote"
    setLicences("WTFPL")
}
artifacts {
    add("archives", tasks["sourcesJar"])
    add("archives", tasks["javadocJar"])
}