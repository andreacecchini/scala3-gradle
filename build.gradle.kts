plugins {
    // Apply scala plugin to add scala support.
    scala
    // Apply scalatest plugin to add scalatest support through `test` task.
    id("com.github.maiflai.scalatest") version "0.33"
    // Apply wortremover plugin for static analysis
    id("io.github.jahrim.wartremover") version "0.1.3"
    // Apply spotless plugin to use scalafmt formatting tool
    id("com.diffplug.spotless") version "8.8.0"
}

tasks.withType<ScalaCompile>().configureEach {
    scalaCompileOptions.additionalParameters = listOf(
        "-Xunchecked-java-output-version",
        JavaVersion.current().majorVersion,
    )
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

dependencies {
    val scala = "3.8.4"
    val (scalaMinor, _) = requireNotNull(
        Regex("^(\\d+)(\\.\\d+)(\\.\\d+)?$")
            .matchEntire(scala)
    )
        .destructured
    implementation("org.scala-lang:scala3-library_$scalaMinor:$scala")
    testImplementation("org.scalatest:scalatest_$scalaMinor:3.2.12")
    testRuntimeOnly("com.vladsch.flexmark:flexmark-all:0.64.8")
}

tasks.withType<Test>().configureEach {
    testLogging {
        events("passed", "failed")
        showCauses = true
    }
}

spotless {
    scala {
        scalafmt("3.11.1").configFile(".scalafmt.conf")
        target("src/**/*.scala")
    }
}

