plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.sergej"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.sergej"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
   
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // UI и AndroidX компоненты
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    // Базовая библиотека для поддержки корутин Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1")
    // Расширение для Activity, которое добавляет lifecycleScope (для delay)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")

    // Тестирование
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
// Вместо старого kotlinOptions { jvmTarget = "17" }
kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}
