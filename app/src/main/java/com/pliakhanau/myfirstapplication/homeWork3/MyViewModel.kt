package com.pliakhanau.myfirstapplication.homeWork3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyViewModel : ViewModel() {

    val cityList = listOf(Region.Minsk, Region.Gomel, Region.Brest)
    var winner = MutableLiveData<String>()

    fun play() {

        CoroutineScope(Dispatchers.IO).launch {

            while (true) {

                for (city in cityList) {
                    city.apply {
                        potato.postValue(potato.value?.plus(Random.nextInt(5)))
                        beet.postValue(beet.value?.plus(Random.nextInt(5)))
                        cabbage.postValue(cabbage.value?.plus(Random.nextInt(5)))
                    }

                    if (city.potato.value!! >= 100
                        && city.beet.value!! >= 100
                        && city.cabbage.value!! >= 100
                    ) {
                        winner.postValue(city.name)
                        return@launch
                    }
                }
                delay(400)
            }
        }
    }
}