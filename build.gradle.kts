plugins {
    scala
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
    implementation("org.scala-lang:scala3-library_3:3.8.4")
}
