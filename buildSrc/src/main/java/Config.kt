object PluginsName {
    val common_build = "common-build"
    val compose_dependencies = "compose-dependencies"
    val section_common = "section-common"
    val room_common_app_db = "room-app-db-commons"
}

object Config {
    val composeVersion = "1.1.1"
    val kotlinVersion = "1.6.10"
    val applicationId = "com.whatsapp.explorer"
    val namespace = "com.whatsapp.explorer"
    val minSdkVersion = 23
    val targetSdkVersion = 32
    val versionCode = appVersion.generateVersionCode()
    val versionName = appVersion.generateVersionName()
    val testInstrumationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val GoogleInstrumentationTestRunner =
        "com.google.android.apps.common.testing.testrunner.GoogleInstrumentationTestRunner"
    val compileSdkVersion = 32
    val buildToolsVersion = "32.0.0"
    val ENABLE_ADS = "ENABLE_ADS"

    object Flav {
        val Dimension = "Main"
        val FlavProduction = "Production"
        val FlavTesting = "Testing"
    }

    object Release {
        val admobMetaId = "com.google.android.gms.ads.com.whatsapp.telegrammanager"
        // config release
        val isShrinkResources = true
        val isMinifyEnabled = true
        // option : testing
        val FIREBASE_ANALYTICS_ACTIVATED = true
        val ADMOB_APP_ID = Admob.RealAds.AppId
        val ENABLE_ADS = "false"
    }
    object Debug {
        val admobMetaId = "com.google.android.gms.ads.com.whatsapp.telegrammanager.testing"
        val isDebuggable = false
        val isShrinkResources = false
        val isMinifyEnabled = false
        val isCrunchPngs = false
        val isCrunchPngsDefault = false
        val versionNameSuffix = "-debug"
        val applicationIdSuffix = ".debug"
        // option : testing
        val FIREBASE_ANALYTICS_ACTIVATED = false
        val ADMOB_APP_ID = Admob.TestAds.AppId
        val ENABLE_ADS = "false"
        object splits {
            object abi {
                val isEnable = true
                val includes = arrayOf("armeabi-v7a", "x86", "x86_64")
                val armabis = arrayOf("arm64-v8a","x86")
                val armeabi_v7a = "armeabi-v7a"
                val arm64_v8a = "arm64-v8a"
                val abi_x86_64 = "x86_64"
                val abi_x86 = "x86"
                val isUniversalApk = false
            }
        }
    }
    object buildName {
        val arm = " arm"
    }
    object buildVarientNames {
        val DEBUG = "debug"
        val STAGGING = "stagging"
        val RELEASE = "release"
    }
    object Admob {
        object FieldName {
            val AppId = "AppId"
            val AppHomeBannerId = "BannerHomeId"
            val AppBannerContentViewId = "BannerContentViewId"
            val AppCleanActivityId = "CleanActivityId"

            val InterstitialVideoPlayerAdUnitId = "InterstitialVideoPlayerAdUnitId"
            val NativeVideoPlayerAdUnitId = "NativeVideoPlayerAdUnitId"
            val InterstitialMusicPlayerAdUnitId = "InterstitialMusicPlayerAdUnitId"
        }

        object TestAds {
            // app id
            val AppId = "\"ca-app-pub-3940256099942544~3347511713\""
            // video player
            val InterstitialVideoPlayerAdUnitId = "\"ca-app-pub-3940256099942544/5224354917\""
            // music player
            val InterstitialMusicPlayerAdUnitId = "\"ca-app-pub-3940256099942544/1044960115\""
            val NativeVideoPlayerAdUnitId = "\"ca-app-pub-3940256099942544/2247696110\""
        }

        object RealAds {
            // swap  : true --> realds ads disabled & swapped with testads
            // true  :  _> Test Ads
            // false : _> Real Ads
            // /* todo : Remove all ads with whatsapp explorer ad */
            val swap = true
            val AppId : String
                get() = if(swap) TestAds.AppId else  "\"ca-app-pub-3940256099942544~3347511713\""
            /* Interstitial Ads */
            val InterstitialVideoPlayerAdUnitId : String
                get() = if(swap) TestAds.InterstitialVideoPlayerAdUnitId else "\"ca-app-pub-3940256099942544/5224354917\""
            /* Music Player */
            val InterstitialMusicPlayerAdUnitId : String
                get() = if(swap) TestAds.InterstitialMusicPlayerAdUnitId else "\"ca-app-pub-3940256099942544/1044960115\""
            val NativeVideoPlayerAdUnitId : String
                get() = if(swap) TestAds.NativeVideoPlayerAdUnitId else "\"ca-app-pub-3940256099942544/2247696110\""
        }

        /* Implemented Real Ads */
//        object RealAds {
//            // app id
//            val AppId = "\"ca-app-pub-1564311228431397~1818154250\"" /* real */
//            // app
//            val AppHomeBannerId = "\"ca-app-pub-1564311228431397/8507685683\"" /* real */
//            val AppBannerContentViewId = "\"ca-app-pub-1564311228431397/6564048623\"" /* real */
//            val AppCleanActivityId = "\"ca-app-pub-1564311228431397/3802153918\"" /* real */
//            // video player
//            val InterstitialVideoPlayerAdUnitId = "\"ca-app-pub-1564311228431397/1311721945\"" /* real */
//            val NativeVideoPlayerAdUnitId = "\"ca-app-pub-1564311228431397/8513680261\"" /*  real  */
//            // music player
//            val InterstitialMusicPlayerAdUnitId = "\"ca-app-pub-1564311228431397/5853602188\"" /* realm */
//        }
    }

    object flavors {
        object fields {
            val content_provider = "content_provider"
        }
    }
}

object BuildConfigFields {
     const val APPLICATION_ID = "APPLICATION_ID"
}
object ManifestConstants {
    val firebase_performance = "firebase_performance"
    val firebase_logging = "firebase_logging"
    val crash_analytics = "crash_analytics"
    val show_ads = "show_ads"
    val FIREBASE_ANALYTICS_ACTIVATED = "FIREBASE_ANALYTICS_DEACTIVATED"
    val ADMOB_APP_ID = "ADMOB_APP_ID"
    val GoogleAdsMetaId = "GoogleAdsMetaId"
}
