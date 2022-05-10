import org.gradle.kotlin.dsl.dependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 23
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
        create(Config.buildVarientNames.STAGGING){}
    }
    buildFeatures {
        this.buildConfig = true
        this.compose = false
        this.viewBinding = true
    }
}

dependencies {
    /* Modules */
    implementation(project(mapOf("path" to ":WhatsApp:Commons")))
    implementation(project(mapOf("path" to ":WhatsApp:Core")))
    implementation(project(mapOf("path" to ":WhatsApp:Data")))
    implementation(project(mapOf("path" to ":WhatsApp:Prefs")))
    implementation(project(mapOf("path" to ":WhatsApp:Utils")))
}