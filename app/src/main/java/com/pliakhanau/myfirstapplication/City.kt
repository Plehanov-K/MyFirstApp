package com.pliakhanau.myfirstapplication

import androidx.lifecycle.MutableLiveData

class City(val name:String) {
    val potato = MutableLiveData<Int>(0)
    val beet = MutableLiveData<Int>(0)
    val cabbage = MutableLiveData<Int>(0)
}