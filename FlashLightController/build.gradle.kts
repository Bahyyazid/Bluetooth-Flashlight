plugins {
    kotlin("android") version "1.9.0" apply false
    id("com.android.application") version "8.1.4" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.4")
        classpath(kotlin("gradle-plugin", "1.9.0"))
    }
}
