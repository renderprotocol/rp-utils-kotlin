plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.nukive.renderprotocol"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    
    // Pulls directly from the GitHub repository via JitPack
    implementation(libs.rp.generated.kotlin)

    testImplementation(libs.junit)
}