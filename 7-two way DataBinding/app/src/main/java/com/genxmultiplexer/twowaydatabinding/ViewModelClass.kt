package com.genxmultiplexer.twowaydatabinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelClass :ViewModel() {
    val username=MutableLiveData<String>()
    init {
        username.value="Samir"
    }
}