package com.sixhundredwatts.protrainr

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp(MultiDexApplication::class)
class TheApplication : MultiDexApplication()