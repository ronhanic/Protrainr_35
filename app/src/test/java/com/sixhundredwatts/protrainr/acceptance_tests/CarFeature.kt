package com.sixhundredwatts.protrainr.acceptance_tests

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.sixhundredwatts.protrainr.Car
import com.sixhundredwatts.protrainr.Engine
import com.sixhundredwatts.protrainr.utils.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import kotlin.time.Duration


class CarFeature {




    val engine = Engine(2000,100,15,false)
    val car = Car(5.0,engine)
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Test
    fun carIsLosingFuelWhenItTurnsOn() = runTest {


        car.turnOn()
        assertEquals(4.5,car.fuel)
    }
    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runTest{
        car.turnOn()

        this.advanceTimeBy(2001)
        assertEquals(25,car.engine.temperature)
        advanceTimeBy(2000)
        assertEquals(50,car.engine.temperature)
        advanceTimeBy(2000)
        assertEquals(95,car.engine.temperature)
        assertTrue(car.engine.isTurnedOn)
    }
}