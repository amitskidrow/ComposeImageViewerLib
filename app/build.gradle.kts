plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.cirline.composeimageviewer"
    compileSdk = 32
    defaultConfig {
        applicationId = "com.cirline.composeimageviewer"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName(Config.buildVarientNames.RELEASE) {
            isDebuggable = false
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        } /* release */
        getByName(Config.buildVarientNames.DEBUG) {
            this.isShrinkResources = false
            this.isMinifyEnabled = false
            this.versionNameSuffix = "-debug"
        }
        create(Config.buildVarientNames.STAGGING) {
            isDebuggable = true
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    if (project.hasProperty("devBuild")) {
        this.splits.abi.isEnable = false
        this.splits.density.isEnable = false
        this.splits.abi.isUniversalApk = false
        this.splits.abi.isUniversalApk = false
        this.aaptOptions.cruncherEnabled = false
    }
    kapt {
        useBuildCache = true
        correctErrorTypes = true
    }
    // Enable splitting for faster apk deployments
    bundle {
        language { enableSplit = true }
        density { enableSplit = true }
        abi { enableSplit = true }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.compose.ui:ui:${Config.composeVersion}")
        implementation("androidx.compose.ui:ui-tooling-preview:${Config.composeVersion}")
    implementation("androidx.compose.material:material:1.1.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Config.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Config.composeVersion}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${Config.composeVersion}")
}