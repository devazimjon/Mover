plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
}


android {
    namespace = "uz.devazimjon.sample.mover"
    compileSdk = 33

    defaultConfig {
        applicationId = "uz.devazimjon.sample.mover"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(project(Modules.core))

    implementation(Coil.coil)
}
