import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

    alias(libs.plugins.android.application)
    alias(libs.plugins.hiltAndroid) apply false

    alias(libs.plugins.jetbrains.kotlin.android)


    alias(libs.plugins.kotlinAndroidKsp) apply false
    alias(libs.plugins.jetbrains.kotlin.kapt)


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
        multiDexEnabled = true

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
        kotlinCompilerExtensionVersion = "1.5.14"
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

    //implementation(kotlin("stdlib", "1.9.24"))

   implementation(libs.androidx.lifecycle.viewmodel.compose)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)


   implementation(libs.androidx.material3)
    implementation(libs.hilt.compose)


    implementation(libs.androidx.room.common)

    implementation(libs.androidx.room.ktx)

    implementation(libs.androidx.compose.navigation)
    implementation(libs.androidx.runtime.livedata)


    androidTestImplementation(libs.androidx.runner)

    implementation(libs.androidx.work.runtime)
    implementation(libs.hiltWork)

    //rob implementation(libs.androidx.hilt.viewmodel)

    //ron  annotationProcessor(libs.hilt.compiler)


    testImplementation(libs.androidx.core.testing)
    androidTestImplementation(libs.androidx.core.testing)


    androidTestImplementation(libs.hilt.android.test)

    testImplementation(libs.hilt.android.test)

   // annotationProcessor(libs.hilt.compiler)
    testImplementation(libs.androidx.core.testing)


    //annotationProcessor(libs.hilt.android.compiler)
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

    implementation(libs.androidx.lifecycle.viewmodel)
    implementation(libs.coreCoroutines)
    implementation(libs.androidCoroutines)
    testImplementation(libs.testCoroutines)

    testImplementation(libs.androidx.test.core)
 //  androidTestImplementation(libs.androidTestRules)
    androidTestImplementation(libs.androidxTestExt)

   // implementation(libs.hilt)
   //  implementation(libs.com.google.dagger.hilt.lifecycle.viewmodel)

    implementation(libs.androidx.multidex)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)

    androidTestImplementation(libs.androidxComposeUiTest)
    //debugImplementation(libs.androidxComposeUiTestDebug)

    kapt(libs.hilt.android.compiler)


}
kapt {
    correctErrorTypes = true
}

apply(plugin="dagger.hilt.android.plugin")

tasks.withType<KotlinCompile> {
    kotlin.ext {
      version = "1.9.24"
    }
}