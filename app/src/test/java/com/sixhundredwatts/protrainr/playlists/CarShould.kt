package com.sixhundredwatts.protrainr.playlists

import com.nhaarman.mockitokotlin2.whenever
import com.sixhundredwatts.protrainr.Car
import com.sixhundredwatts.protrainr.Engine
import com.sixhundredwatts.protrainr.utils.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class CarShould {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    //val engine = Engine(2000,100,15,false)
    val engine:Engine = mock();

    private val car:Car
    init {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow {
                emit(25)
                delay(2000)
                emit(50)
                emit(95)
            })
        }
        car = Car(5.0,engine)
    }

    @Test
    fun losingFuelWhenItTurnsOn() = runTest{
        car.turnOn()
        assertEquals(4.5,car.fuel)
    }
    @Test
    fun turnOnItsEngine() = runTest{

        car.turnOn();

        verify(engine, times(1)).turnOn()
    }

}