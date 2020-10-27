package com.genxmultiplexer.coroutineallinhere

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class UserRepository {


    suspend fun getUsers(): List<Users> {

        delay(1000)

        return listOf(
            Users(10, "samir-1"),
            Users(11, "samir-2"),
            Users(12, "samir-3"),
            Users(13, "samir-5"),
            Users(14, "samir-6"),
            Users(15, "samir-8"),
            Users(16, "samir-7")
        )

    }


    suspend fun autoUser() : List<String>? {

        var list:List<String>?=null
        for (index in 1..2000){
            delay(1000)
            list= listOf("Element-$index")
        }

        return list
    }
}