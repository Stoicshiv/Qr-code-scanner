// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}
dependencies {
    implementation 'com.journeyapps:zxing-android-embedded:4.3.0' // QR code scanner
    implementation 'org.apache.poi:poi-ooxml:5.2.3'               // Excel handling
}
