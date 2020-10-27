package com.genxmultiplexer.customviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var total = MutableLiveData<Int>()

    val totalData:LiveData<Int>
    get() = total


    init {
        total.value=0
    }




    fun setTotal(input:Int) {
        total.value= (total.value)?.plus(input)


    }

}