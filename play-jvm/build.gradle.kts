plugins {
    java
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
        testImplementation("org.assertj:assertj-core:3.24.2")
    }

    repositories {
        mavenCentral()
    }

    tasks.test {
        useJUnitPlatform()
    }
}
