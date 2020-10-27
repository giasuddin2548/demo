package com.genxmultiplexer.viewmodel_1.ViewModels

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var count = 0
    private var total = 0

    fun getCurrentPosition(): Int {
        return count
    }

    fun getUpdatedPosition(): Int {
        return ++count
    }

    fun getTotal(): Int {
        return total
    }

    fun setTotal(input:Int) {
        total += input


    }

}