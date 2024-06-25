plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.kotlinAndroidKsp) apply false

}

android {
    namespace = "com.sixhundredwatts.protrainr"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.sixhundredwatts.protrainr"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        // multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        //testInstrumentationRunner = "com.sixhundredwatts.protrainr.HiltTestRunner"


    }

    //   buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
    //   }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"

            excludes += "/META-INF/gradle/incremental.annotation.processors"


        }
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



    implementation(libs.androidx.room.common)

    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.compose.navigation)


    androidTestImplementation(libs.androidx.runner)

    //implementation(libs.com.google.dagger.hilt.lifecycle.viewmodel)
    //  implementation(libs.hilt)
    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.core.testing)


    androidTestImplementation(libs.hilt.android.test)

    testImplementation(libs.hilt.android.test)

    testImplementation(libs.androidx.core.testing)


    //ksp(libs.hilt.compiler)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    testImplementation(libs.org.mockito.android)


    androidTestImplementation(libs.baristas) {
        this.exclude(group="org.jetbrains.kotlin")
    }

    androidTestImplementation(platform(libs.androidx.compose.bom))

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    testImplementation(libs.androidx.ui.test.junit4)

    testImplementation(libs.mockito.org)
    testImplementation(libs.mockito.kotlin)

    implementation(libs.coreCoroutines)
    implementation(libs.androidCoroutines)
    testImplementation(libs.testCoroutines)

    testImplementation(libs.androidx.test.core)
 //  androidTestImplementation(libs.androidTestRules)
    androidTestImplementation(libs.androidxTestExt)



    implementation(libs.androidx.multidex)
    implementation(libs.hilt.android)
    annotationProcessor(libs.hilt.compiler)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    androidTestImplementation(libs.androidxComposeUiTest)
    //debugImplementation(libs.androidxComposeUiTestDebug)




}
