plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("maven-publish")
}
android {
    namespace = "com.cirline.composeimageviewer"
    compileSdk = Config.compileSdkVersion
    defaultConfig {
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures { compose = true }
    composeOptions {
        kotlinCompilerExtensionVersion = Config.composeVersion
    }
    buildTypes {
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
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro")
        }
        create(Config.buildVarientNames.STAGGING){}
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
}

dependencies {
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.Kotlin.stdlib)
    implementation(Libs.Google.google_material)
    //Coroutines and LifeCycle Libraries
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)
    // livedata
    implementation(Libs.AndroidX.lifecycle_runtime_ktx)
    // datastore
    implementation(Libs.AndroidX.datastore_preferences)
    // jetpack compose
    implementation(Libs.AndroidX.Compose.ui_binding)
    implementation(Libs.AndroidX.Compose.livedata)
    implementation(Libs.AndroidX.Compose.navigation)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.tooling)
    debugImplementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Activity.activityCompose)
    // glide
    implementation(Libs.landscapist.glide)
    // fragment ktx
    implementation(Libs.AndroidX.fragment_ktx)
    // accompanist pager
    implementation(Libs.Accompanist.pager)
    // system ui controller
    implementation(Libs.Accompanist.system_ui_controller)

    /* compose coil imageloader */
    implementation(Libs.coil.coil_gif)
    implementation(Libs.coil.coil_compose)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "compose-image-viewer"
                artifactId = "com.cirline.imageviewer"
                version = "1.0"
                from(components["release"])
            }
        }
    }
}