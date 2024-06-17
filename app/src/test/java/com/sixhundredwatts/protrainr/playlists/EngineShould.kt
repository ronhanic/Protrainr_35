package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.Car
import com.sixhundredwatts.protrainr.Engine
import com.sixhundredwatts.protrainr.utils.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()


    //val engine = Engine(2000,100,15,false)
    val engine:Engine = Engine(2000,100,15,false)
   // val engine = mock()
    val car = Car(5.0,engine)
    //val car = mock()
    @Test
    fun turnOn() = runTest {
        engine.turnOn()
        assertTrue(engine.isTurnedOn)
        assertEquals(95,engine.temperature)

    }
    @Test
    fun rideTheTemperatureGraduallyWhenItTurnsOn() = runTest  {
        val flow: Flow<Int> = engine.turnOn()
        val actual :List<Int> = flow.toList()

        assertEquals(listOf(25,50,95), actual)

    }
    @Test
    fun turnOff() = runTest {

        engine.turnOff();
        assertFalse(engine.isTurnedOn)
        assertEquals(15,engine.temperature)


    }

}