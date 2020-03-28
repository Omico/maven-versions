plugins {
    application
    kotlin("jvm") version "1.3.71"
}

application {
    mainClassName = "me.omico.maven.Versions"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.squareup.okhttp3:okhttp:4.4.1")
    implementation("com.squareup.retrofit2:converter-scalars:2.8.1")
    implementation("com.squareup.retrofit2:retrofit:2.8.1")
    implementation("org.jsoup:jsoup:1.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

group = "me.omico"
version = "1.0-SNAPSHOT"
