plugins {
    `kotlin-dsl`
}

group = "com.github.ynverxe"
version = "0.1.0"

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