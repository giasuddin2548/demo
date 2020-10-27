package com.genxmultiplexer.twowaydatabindingcodingchallage

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass :ViewModel () {
    private var count=MutableLiveData<Int>()

    init {
        count.value=0
    }
    val countData:LiveData<Int>
    get() = count


    val inputText=MutableLiveData<String>()

    fun countUpdate(){
        val inputValue:Int= inputText.value!!.toInt()

        count.value=count.value?.plus(inputValue )
    }
}