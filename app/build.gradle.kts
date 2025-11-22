plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
}

android {
    namespace = "com.example.demo"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.demo"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
// Gson converter (for JSON parsing)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")



    implementation("io.ktor:ktor-client-core:2.3.12")

    // Android engine (uses OkHttp under the hood)
    implementation("io.ktor:ktor-client-android:2.3.12")

    // JSON serialization with Kotlinx
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.12")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")

    // Logging (for debugging API calls)
    implementation("io.ktor:ktor-client-logging:2.3.12")

    // Coroutines (needed for suspend functions in networking)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")


    implementation("io.insert-koin:koin-android:4.1.1")


    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1") // for annotation processing

// Kotlin Extensions + Coroutines support
    implementation("androidx.room:room-ktx:2.6.1")


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")

    // REQUIRED for viewModel() in Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")


    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
}