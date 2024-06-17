package com.sixhundredwatts.protrainr

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Car(
    var fuel:Double,
    val engine:Engine
) {
    fun turnOn() {
        fuel -= 0.5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collect { temperature ->
                var temp = temperature
               // Log.d("COURSE","text $temp")
                var x = 1
            }
        }

    }
}