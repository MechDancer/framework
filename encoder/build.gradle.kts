import com.novoda.gradle.release.PublishExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
    plugin("com.novoda.bintray-release")
}

version = "0.0.1-dev-1"

dependencies {
    compile(kotlin("stdlib"))
    compile(project(":dependency"))
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
    desc = "encoder"
    website = "https://github.com/MechDancer/framework/encoder"
    setLicences("WTFPL")
}

artifacts {
    add("archives", tasks["sourcesJar"])
    add("archives", tasks["javadocJar"])
}