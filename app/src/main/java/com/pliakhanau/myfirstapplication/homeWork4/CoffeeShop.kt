package com.pliakhanau.myfirstapplication.homeWork4

class CoffeeShop private constructor() {

    val coffeeList = ArrayList<Coffee>(3)

    companion object {
        val instance = CoffeeShop()
    }
}