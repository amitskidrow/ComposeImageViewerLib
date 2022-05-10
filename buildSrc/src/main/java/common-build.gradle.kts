import com.android.build.gradle.ProguardFiles.getDefaultProguardFile

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    this.compileSdk = Config.compileSdkVersion
    this.buildTypes {
        getByName("debug") {
            splits {
                abi {
                    this.reset()
                    this.isEnable = Config.Debug.splits.abi.isEnable
                    this.include(*Config.Debug.splits.abi.includes)
                    this.isUniversalApk = Config.Debug.splits.abi.isUniversalApk
                }
            }
            this.isShrinkResources = Config.Debug.isShrinkResources
            this.isMinifyEnabled = Config.Debug.isMinifyEnabled
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }
    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        testInstrumentationRunner = Config.testInstrumationRunner
        consumerProguardFiles("consumer-rules.pro")
        testInstrumentationRunnerArguments["androidx.benchmark.suppressErrors"] = "DEBUGGABLE"
    }
    if (project.hasProperty("devBuild")) {
        this.splits.abi.isEnable = false
        this.splits.density.isEnable = false
        this.splits.abi.isUniversalApk = false
        this.splits.abi.isUniversalApk = false
        this.aaptOptions.cruncherEnabled = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    kapt {
        useBuildCache = true
        correctErrorTypes = true
    }
}
dependencies {
    /* base */
    implementation(project(mapOf("path" to ":WhatsApp:Base")))
    implementation(fileTree(baseDir = "libs"))
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.Google.google_material)
    // Test
    testImplementation(Libs.JUnit.junit)
    androidTestImplementation(Libs.JUnit.junitAndroidTest)
    androidTestImplementation(Libs.JUnit.espressoAndroidTest)
}