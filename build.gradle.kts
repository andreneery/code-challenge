plugins {
    kotlin("jvm") version "1.8.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.13.4")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}
