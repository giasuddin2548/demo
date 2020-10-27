package com.genxmultiplexer.retrofitusingmvvm

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.genxmultiplexer.retrofitusingmvvm.databinding.ActivityMainBinding
import com.genxmultiplexer.retrofitusingmvvm.network.AlbumService
import com.genxmultiplexer.retrofitusingmvvm.network.Albums
import com.genxmultiplexer.retrofitusingmvvm.network.AlbumsItem
import com.genxmultiplexer.retrofitusingmvvm.network.RetrofitInstance
import com.genxmultiplexer.retrofitusingmvvm.utils.hide
import com.genxmultiplexer.retrofitusingmvvm.utils.myToast
import com.genxmultiplexer.retrofitusingmvvm.utils.show
import com.genxmultiplexer.retrofitusingmvvm.view.ViewModelClass
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModelClass::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventData.observe(this, Observer { myEvent ->
            myEvent.getContentIfNotHandled()?.let {
                myToast(it)
            }
        })



        viewModel.respondLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()

            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    textViewTitleId.append("${albumItem.title}\n\n")
                }
            }


        })


        viewModel.respondSortedLiveData.observe(this, Observer {
            val albumList = it.body()?.listIterator()

            if (albumList != null) {
                while (albumList.hasNext()) {
                    val albumItem = albumList.next()
                    Log.d("MYTAG",albumItem.title)
                }
            }


        })


        viewModel.respondAlbumByPathLiveData.observe(this, Observer {
            val album: String? = it.body()?.title

            Log.d("MYTAG3",album.toString())


        })


        viewModel.postResponse.observe(this, Observer {
            val album: AlbumsItem? = it.body()

            Log.d("MYTAG10",album.toString())

        })



     



    }

}