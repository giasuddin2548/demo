package com.genxmultiplexer.livedatawithdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass : ViewModel(){
    private val count=MutableLiveData<Int>()
    init {
        count.value=0
    }

    val countData:LiveData<Int>
    get() = count


    fun countUpdate(){
        count.value=count.value?.plus(1)
    }
}