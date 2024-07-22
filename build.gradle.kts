plugins {
    id("java")
    `kotlin-dsl`
}

group = "com.github.ynverxe"
version = "0.1.0"

repositories {
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