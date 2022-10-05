package com.example.diceroller

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun generates_number() {
        val numSides = 22
        val dice = Dice(numSides)
        val roll = dice.roll()
        assertTrue(roll > 0)
        assertTrue(roll <= numSides)
    }
}