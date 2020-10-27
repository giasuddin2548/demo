package com.genxmultiplexer.recyclerviewmvvm.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.recyclerviewmvvm.network.Repository

class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelClass::class.java)) {

            return ViewModelClass(repository) as T
        }

        throw IllegalArgumentException("Unknown class")

    }
}