package com.github.ynverxe.privatelogic

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import java.io.File
import java.nio.file.Files

abstract class PrivateLogicPlugin : Plugin<Project> {
    @get:Input
    @get:Optional
    abstract val scriptsDirectory: Property<String?>

    override fun apply(target: Project) {

        target.extensions.create("privateLogic", PrivateLogicPlugin::class.java)

        target.afterEvaluate {
            val file = target.file(scriptsDirectory.getOrElse("private-logic"))

            val path = file.toPath()

            if (!Files.exists(path)) {
                return@afterEvaluate
            }

            require(Files.isDirectory(path)) { "$path is not a directory" }

            val files = file.listFiles { dir: File?, name: String ->
                name.endsWith(
                    ".gradle"
                ) || name.endsWith(".gradle.kts")
            }

            if (files == null)
                return@afterEvaluate

            for (scriptFile in files) {
                println("Adding script file '$scriptFile'")
                target.apply { from(target.file(scriptFile)) }
            }
        }
    }
}