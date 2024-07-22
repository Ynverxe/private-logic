plugins {
    `kotlin-dsl`
    id("maven-publish")
}

group = "com.github.ynverxe"
version = "0.1.0"

java {
    withJavadocJar()
    withSourcesJar()
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("private-logic") {
            id = "com.github.ynverxe.private-logic"
            implementationClass = "com.github.ynverxe.privatelogic.PrivateLogicPlugin"
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
            groupId = project.group.toString()
            version = project.version.toString()

            from(components["kotlin"])

            pom {
                name = "private-logic"
                description = "A gradle plugin to load personal logic on group projects"
                url = "https://github.com/Ynverxe/private-logic"
                developers {
                    developer {
                        id = "Ynverxe"
                        url = "https://github.com/Ynverxe"
                    }
                }
            }
        }
    }
}