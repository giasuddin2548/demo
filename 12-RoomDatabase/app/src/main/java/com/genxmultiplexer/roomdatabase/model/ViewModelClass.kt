package com.genxmultiplexer.roomdatabase.model

import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genxmultiplexer.roomdatabase.database.SubscriberEntity
import com.genxmultiplexer.roomdatabase.database.SubscriberRepository
import com.genxmultiplexer.roomdatabase.utils.Event
import kotlinx.coroutines.*
import java.util.regex.Pattern

class ViewModelClass(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscriber = repository.getAllSubscriber

    private var isSuUpdateOrDelete: Boolean = false
    private lateinit var subscriberToUpdateOrDelete: SubscriberEntity


    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage


    @Bindable
    val inputName = MutableLiveData<String>()

    @Bindable
    val inputEmail = MutableLiveData<String>()

    @Bindable
    val saveOrUpdateButtonText = MutableLiveData<String>()

    @Bindable
    val clearOrDeleteButtonText = MutableLiveData<String>()

    init {
        saveOrUpdateButtonText.value = "Save"
        clearOrDeleteButtonText.value = "Clear"
    }

    fun cancelButton() {
        if (isSuUpdateOrDelete) {
            delete(subscriberToUpdateOrDelete)
        } else {
            deleteAll()
        }
    }

    fun saveButton() {










        if (inputName.value == null) {

            statusMessage.value = Event("Subscriber name required ")

        } else if (inputEmail.value == null) {

            statusMessage.value = Event("Subscriber  email required ")

        } else if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail.value!!).matches()) {
            statusMessage.value = Event("Please Enter correct email ")

        } else {
            if (isSuUpdateOrDelete) {
                subscriberToUpdateOrDelete.sub_name = inputName.value!!
                subscriberToUpdateOrDelete.sub_email = inputEmail.value!!
                update(subscriberToUpdateOrDelete)

            } else {
                val name = inputName.value!!
                val email = inputEmail.value!!
                insert(SubscriberEntity(0, name, email))
                inputName.value = null
                inputEmail.value = null
            }
        }



















    }



    fun updateAndDelete(subscriberEntity: SubscriberEntity) {
        inputName.value = subscriberEntity.sub_name
        inputEmail.value = subscriberEntity.sub_email
        isSuUpdateOrDelete = true
        subscriberToUpdateOrDelete = subscriberEntity
        saveOrUpdateButtonText.value = "Update"
        clearOrDeleteButtonText.value = "Delete"
    }



    private fun insert(subscriberEntity: SubscriberEntity): Job = viewModelScope.launch {
        val newRowId: Long = repository.insertSubs(subscriberEntity)


        if (newRowId > -1) {
            statusMessage.value = Event("Subscriber added successfully at $newRowId")
        } else {
            statusMessage.value = Event("Error occurred at $newRowId")
        }

    }

    private fun update(subscriberEntity: SubscriberEntity): Job = viewModelScope.launch {
        val rowId: Int = repository.updateSubs(subscriberEntity)
        if (rowId > 0) {
            inputName.value = null
            inputEmail.value = null
            isSuUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearOrDeleteButtonText.value = "Clear all"
            statusMessage.value = Event("Subscriber updated successfully $rowId")
        } else {
            statusMessage.value = Event("Error occurred: data not updated at $rowId")
        }
    }

    private fun delete(subscriberEntity: SubscriberEntity): Job = viewModelScope.launch {
        val rowId: Int = repository.deleteSubs(subscriberEntity)
        if (rowId > 0) {
            inputName.value = null
            inputEmail.value = null
            isSuUpdateOrDelete = false
            saveOrUpdateButtonText.value = "Save"
            clearOrDeleteButtonText.value = "Clear all"
            statusMessage.value = Event("Subscriber id $rowId has been Deleted")
        } else {
            statusMessage.value = Event("Subscriber id $rowId has not been Deleted")
        }

    }

    private fun deleteAll(): Job = viewModelScope.launch {
        val rowId: Int = repository.deleteAllSubs()
        if (rowId > 0) {
            statusMessage.value = Event("All ($rowId) Subscribers deleted successfully")
        } else {
            statusMessage.value = Event("Error occurred ($rowId) ")
        }
    }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }


}