package com.genxmultiplexer.roomdatabase.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.roomdatabase.database.SubscriberRepository
import java.lang.IllegalArgumentException

class SubscriberViewModelFactory(private val repository: SubscriberRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelClass::class.java)){
            return ViewModelClass(repository) as T
        }

        throw IllegalArgumentException("Unknown view model class")
    }
}