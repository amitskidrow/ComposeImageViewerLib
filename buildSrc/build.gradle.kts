plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}
dependencies {
    implementation("com.android.tools.build:gradle:7.3.0-alpha09")
    implementation("com.android.tools.build:gradle-api:7.3.0-alpha09")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}
// Required since Gradle 4.10+.
repositories {
    jcenter()
    google()
    mavenLocal()
    mavenCentral()
}
