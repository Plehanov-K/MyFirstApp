package com.pliakhanau.myfirstapplication.homeWorkTests

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciTest {

    @Test
    fun checkNumberFibonacci_returns_true() {
        var result = true
        val map = mapOf(
            0 to 0,
            1 to 1,
            2 to 1,
            3 to 2,
            4 to 3,
            5 to 5,
            6 to 8,
            7 to 13,
            8 to 21,
            9 to 34,
            10 to 55
        )
        for ((key, value) in map) {
            result = (value == Fibonacci.counter(key))
            assertThat(result).isTrue()
        }
    }
}
