package com.genxmultiplexer.coroutineallinhere

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers

class ViewModelClass : ViewModel() {
    private var userRepository = UserRepository()

    var userLiveData= liveData(Dispatchers.IO) {
        val resutl=userRepository.getUsers()
        emit(resutl)
    }

    var autoUserLiveData= liveData(Dispatchers.IO) {
        val resutl=userRepository.autoUser()
        emit(resutl)
    }


    fun onClickForList(view:View){
        
    }


//    val userLiveData: MutableLiveData<List<Users>> = MutableLiveData()

//    fun getUserData() {
//        viewModelScope.launch {
//            var list: List<Users>? = null
//            withContext(Dispatchers.IO) {
//                list = userRepository.getUsers()
//            }
//            userLiveData.value = list
//        }
//
//
//
//    }

    /*
    suspend fun getStock1(): Int {
        delay(10000)
        Log.i("MYTAG", "Stack-1 called")
        return 1000
    }

    suspend fun getStock2(): Int {
        delay(8000)
        Log.i("MYTAG", "Stack-2 called")
        return 1000
    }

    suspend fun getStock3(): Int {
        delay(6000)
        Log.i("MYTAG", "Stack-3 called")
        return 1000
    }

    suspend fun getStock4(): Int {
        delay(1000)
        Log.i("MYTAG", "Stack-4 called")
        return 1000
    }

     */
}