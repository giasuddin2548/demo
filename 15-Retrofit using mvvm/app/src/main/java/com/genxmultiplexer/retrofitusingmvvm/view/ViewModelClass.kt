package com.genxmultiplexer.retrofitusingmvvm.view

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.genxmultiplexer.retrofitusingmvvm.network.AlbumService
import com.genxmultiplexer.retrofitusingmvvm.network.Albums
import com.genxmultiplexer.retrofitusingmvvm.network.AlbumsItem
import com.genxmultiplexer.retrofitusingmvvm.network.RetrofitInstance
import com.genxmultiplexer.retrofitusingmvvm.utils.Event
import com.genxmultiplexer.retrofitusingmvvm.utils.show
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import retrofit2.Response

class ViewModelClass : ViewModel(),Observable {

    private val event = MutableLiveData<Event<String>>()
    val eventData: LiveData<Event<String>>
        get() = event


    private val retService= RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)


    val respondLiveData: LiveData<Response<Albums>> = liveData{
        val response=retService.getAlbums()
        emit(response)
    }


    val respondSortedLiveData: LiveData<Response<Albums>> = liveData{
        val response=retService.getSortedAlbums(1)
        emit(response)
    }



    val respondAlbumByPathLiveData: LiveData<Response<AlbumsItem>> = liveData{
        val response=retService.getAlbumsByPath(1)
        emit(response)
    }

    val postResponse:LiveData<Response<AlbumsItem>> = liveData {
        val response=retService.postAlbums(AlbumsItem(0,"Samir",3))
        emit(response)
    }












    @Bindable
    val startButtonText = MutableLiveData<String>()

    @Bindable
    val stopButtonText = MutableLiveData<String>()

    init {
        startButtonText.value = "Start"
        stopButtonText.value = "Stop"
    }


    fun startButtonClick(){

    }


    fun stopButtonClick(){

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}