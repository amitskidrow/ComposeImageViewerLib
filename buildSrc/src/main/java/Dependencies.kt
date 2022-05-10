/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Versions {
    const val ktlint = "0.41.0"
    const val lifecycle_version = "2.4.1"
    const val preference_version = "1.2.0"
}

object Libs {
    val loupe = "com.igreenwood.loupe:loupe:1.2.1"
    val loupe_extensions = "com.igreenwood.loupe:extensions:1.0.0"
    // custom progressbar
    const val vertical_seekbar = "com.lukelorusso:verticalseekbar:1.2.4"
    const val timber = "com.jakewharton.timber:timber:5.0.1"
    const val apache_commons = "commons-io:commons-io:2.11.0"
    const val file_chooser = "com.obsez.android.lib.filechooser:filechooser:1.2.0"
    const val protoBuf_java_lite = "com.google.protobuf:protobuf-javalite:3.18.0"
    const val thumbnail_jen = "com.github.makbn:JThumbnail:master-SNAPSHOT"
    const val rxPermissions = "com.github.tbruyelle:rxpermissions:0.12"
    const val simpleStorage = "com.anggrayudi:storage:1.3.0"
    object Google {
        const val google_material = "com.google.android.material:material:1.4.0"
        const val play_services_ads = "com.google.android.gms:play-services-ads:20.4.0"
        const val play_core_ktx = "com.google.android.play:core-ktx:1.8.1"
        const val gson = "com.google.code.gson:gson:2.8.9"
    }

    object coil {
        // Coil
        const val version = "1.4.0"
        const val coil_compose = "io.coil-kt:coil-compose:$version"
        const val coil_gif = "io.coil-kt:coil-gif:$version"
        const val coil_video = "io.coil-kt:coil-video:$version"
    }

    object Glide {
        val glide = "com.github.bumptech.glide:glide:4.13.0"
        val glideCompiler = "com.github.bumptech.glide:compiler:4.13.0"
    }
    object landscapist {
        const val glide = "com.github.skydoves:landscapist-glide:1.1.7"
        const val coil = "com.github.skydoves:landscapist-coil:1.4.3"
        const val fresco = "com.github.skydoves:landscapist-fresco:1.4.5"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.3.0-alpha05"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"

    object hilt {
        const val hilt_android = "com.google.dagger:hilt-android:2.38.1"
        const val hilt_android_compiler_kapt = "com.google.dagger:hilt-android-compiler:2.38.1"
        const val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02"
        const val hilt_compiler_kapt = "androidx.hilt:hilt-compiler:1.0.0-alpha02"
    }

    object Accompanist {
        const val version = "0.24.3-alpha"
        const val system_ui_controller = "com.google.accompanist:accompanist-systemuicontroller:$version"
        const val pager = "com.google.accompanist:accompanist-pager:$version"
        const val pager_indicator = "com.google.accompanist:accompanist-pager-indicators:$version"
        const val coil = "com.google.accompanist:accompanist-coil:0.15.0"
        const val insets = "com.google.accompanist:accompanist-insets:$version"
        const val permission = "com.google.accompanist:accompanist-permissions:$version"
        const val nav_anim = "com.google.accompanist:accompanist-navigation-animation:$version"
        const val nav_material = "com.google.accompanist:accompanist-navigation-material:$version"
    }

    object Kotlin {
        private const val version = "1.6.10"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
    }

    object Coroutines {
        private const val version = "1.4.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }
    // firebase
    object firebase {
        // Import the BoM for the Firebase platform
        val firebase_platform_bom = "com.google.firebase:firebase-bom:28.4.1"

        // Declare the dependencies for the Crashlytics and Analytics libraries
        // When using the BoM, you don"t specify versions in Firebase library dependencies
        val firebase_crash_analytics = "com.google.firebase:firebase-crashlytics-ktx"
        val firebase_analytics = "com.google.firebase:firebase-analytics-ktx"

        // Declare the dependency for the Performance Monitoring library
        val firebase_performance_monitoring = "com.google.firebase:firebase-perf-ktx"

        // firebase ads
        val firebase_ads = "com.google.firebase:firebase-ads:20.3.0"
    }

    object Rxjava {
        val rx_android = "io.reactivex.rxjava3:rxandroid:3.0.0"
        val rx_kotlin = "io.reactivex.rxjava3:rxkotlin:3.0.0"
        val rxjava_extensions = "com.github.akarnokd:rxjava3-extensions:3.0.1"
    }

    object JUnit {
        private const val version = "4.13"
        const val junit = "junit:junit:$version"
        const val junitAndroidTest = "androidx.test.ext:junit:1.1.3"
        const val espressoAndroidTest = "androidx.test.espresso:espresso-core:3.4.0"
    }

    object permission  {
        const val version = "4.9.2"
        const val dispatcher = "com.github.permissions-dispatcher:permissionsdispatcher:$version"
        const val dispatcher_kapt = "com.github.permissions-dispatcher:permissionsdispatcher-processor:$version"
    }
    // ExoPlayer
    object Exoplayer {
        const val version = "2.16.1"
        const val core = "com.google.android.exoplayer:exoplayer-core:${version}"
        const val ui = "com.google.android.exoplayer:exoplayer-ui:${version}"
        const val exoplayer_dash = "com.google.android.exoplayer:exoplayer-dash:${version}"
        const val mediasession = "com.google.android.exoplayer:extension-mediasession:${version}"
    }
    object AndroidX {
        const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:2.4.1"
        const val navigation_ui = "androidx.navigation:navigation-ui-ktx:2.4.1"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val documentFile = "androidx.documentfile:documentfile:1.1.0-alpha01"
        // datastore
        // Kotlin
        const val broadcast_manager = "androidx.localbroadcastmanager:localbroadcastmanager:1.1.0"
        const val splash_screen = "androidx.core:core-splashscreen:1.0.0-alpha01"
        const val fragment_ktx = "androidx.fragment:fragment-ktx:1.4.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.1.0-beta01"
        const val preference_ktx = "androidx.preference:preference-ktx:${Versions.preference_version}"
        const val datastore_core = "androidx.datastore:datastore-core:1.0.0"
        const val datastore_preferences = "androidx.datastore:datastore-preferences:1.0.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
        const val appcompat = "androidx.appcompat:appcompat:1.3.1"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha01"
        const val recyclerview_selection = "androidx.recyclerview:recyclerview-selection:1.2.0-alpha01"
        const val coreKtx = "androidx.core:core-ktx:1.9.0-alpha01"
        const val navigation = "androidx.navigation:navigation-compose:2.4.0-alpha04"
        const val activity_ktx = "androidx.activity:activity-ktx:1.2.4"
        const val legacy_support = "androidx.legacy:legacy-support-v4:1.0.0"
        // live data
        const val lifecycle_viewmodel_ktx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
        const val lifecycle_livedata_ktx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
        const val lifecycle_runtime_ktx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
        const val lifecycle_common =
            "androidx.lifecycle:lifecycle-common:${Versions.lifecycle_version}"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.3.0-rc01"
        }

        object Compose {
            const val snapshot = ""
            const val version = "1.2.0-alpha04"
            const val contraint_layout_compose = "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
            const val ui_binding = "androidx.compose.ui:ui-viewbinding:${version}"
            const val navigation = "androidx.hilt:hilt-navigation-compose:1.0.0-beta01"
            const val livedata = "androidx.compose.runtime:runtime-livedata:${version}"
            const val animation = "androidx.compose.animation:animation:$version"
            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
            const val material = "androidx.compose.material:material:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val ui = "androidx.compose.ui:ui:$version"
            const val uiUtil = "androidx.compose.ui:ui-util:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        }

        object ConstraintLayout {
            const val constraintLayoutCompose =
                "androidx.constraintlayout:constraintlayout-compose:1.0.0-alpha08"
        }

        object Test {
            private const val version = "1.3.0"
            const val core = "androidx.test:core:$version"
            const val rules = "androidx.test:rules:$version"

            object Ext {
                private const val version = "1.1.2"
                const val junit = "androidx.test.ext:junit-ktx:$version"
            }

            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }
}
