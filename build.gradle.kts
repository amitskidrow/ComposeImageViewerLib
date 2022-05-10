buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
        maven(url = "https://maven.google.com/")
        maven(url = "https://jitpack.io")
    }
//    dependencies {
//        // NOTE: Do not place your application dependencies here; they belong
//        classpath("com.android.tools.build:gradle:7.3.0-alpha09")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
//    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.library") apply false
    id("org.jetbrains.kotlin.android") apply false
}

tasks.register("clean").configure {
    delete("build")
}
