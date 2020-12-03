package com.pliakhanau.myfirstapplication.homeWorkTests

object Fibonacci {

    fun counter(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 2) return 1
        var x = 1
        var y = 1
        var ans = 0
        for (i in 3..n) {
            ans = x + y
            x = y
            y = ans
        }
        return ans
    }
}