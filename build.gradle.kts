plugins {
    kotlin("jvm") version "1.5.31"
}

description = "ClassicBridge"

allprojects {
    group = "dev.winx64"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8", "1.3.72"))
    testImplementation(kotlin("test", "1.3.72"))
}
