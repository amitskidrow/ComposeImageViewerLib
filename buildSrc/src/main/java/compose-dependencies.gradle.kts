plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

dependencies {
    /* compose support */
    implementation(Libs.AndroidX.navigation)
    implementation(Libs.AndroidX.Compose.ui_binding)
    implementation(Libs.AndroidX.Compose.livedata)
    implementation(Libs.AndroidX.Compose.navigation)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.uiUtil)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Compose.contraint_layout_compose)
    implementation(Libs.AndroidX.Activity.activityCompose)
}