
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.nexera.articleapp"
    compileSdk = 33
    
    defaultConfig {
        applicationId = "com.nexera.articleapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

dependencies {

    implementation(platform("androidx.compose:compose-bom:2022.10.00"))

    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.5.1")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui")
}
