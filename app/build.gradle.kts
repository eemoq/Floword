import java.util.Properties
import java.io.FileInputStream

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.floword"
    compileSdk = 35


        buildFeatures {
            buildConfig = true
        }

        defaultConfig {
            applicationId = "com.example.floword"
            minSdk = 24
            targetSdk = 35
            versionCode = 1
            versionName = "1.0"

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


            // 读取 local.properties 文件
            val localProperties = Properties().apply {
                load(project.rootProject.file("local.properties").inputStream())
            }

            val apiKey = localProperties.getProperty("apikey", "")
                ?: throw GradleException ("API Key not found in local.properties!")

            buildConfigField("String", "API_KEY", "\"$apiKey\"")

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
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }

    dependencies {
        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        implementation(libs.retrofit2.retrofit)
        implementation(libs.converter.gson)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
        implementation(libs.glide)
    }