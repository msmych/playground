plugins {
    java
    kotlin("jvm") version "1.9.23"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    runtimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.assertj:assertj-core:3.24.2")
}

tasks.test {
    useJUnitPlatform()
    sourceSets {
        test {
            java.srcDirs("src/test/java", "src/main/java")
            kotlin.srcDirs("src/test/kotlin", "src/main/kotlin")
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}
