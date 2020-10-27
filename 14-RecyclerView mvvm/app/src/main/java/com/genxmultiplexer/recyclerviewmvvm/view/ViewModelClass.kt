package com.genxmultiplexer.recyclerviewmvvm.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genxmultiplexer.recyclerviewmvvm.network.Repository
import com.genxmultiplexer.recyclerviewmvvm.network.StudentDataEntity
import kotlinx.coroutines.*

class ViewModelClass(private val repository: Repository) : ViewModel() {

    val studentList = repository.getAllStudent

    fun buttonClicked() {
        CoroutineScope(Dispatchers.IO).launch {

            
            for (index in 1..1000){
                 delay(1000)
                insert(StudentDataEntity(0,"Samir-$index","Hello I'm Samir-$index"))
            }

        }

    }


    private fun insert(studentDataEntity: StudentDataEntity): Job = viewModelScope.launch {
        repository.insertStudent(studentDataEntity)
    }

}