plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.compose") version "1.5.11"
}

group = "com.morgana.ide"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}
tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}