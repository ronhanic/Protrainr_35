package com.sixhundredwatts.protrainr

import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

class EngineTest {
    private val engine = Engine(2000,189 ,15,false)

    @Test
    fun engineTurnsOn() = runBlockingTest{
        engine.turnOn()
        assertEquals(true,engine.isTurnedOn )
        assertEquals( 95, engine.temperature)
    }

    @Test
    fun engineTurnsOff() = runBlockingTest {
        engine.turnOn()
        engine.turnOff()
        assertEquals(false,engine.isTurnedOn )
        assertEquals( 15, engine.temperature)
    }
}