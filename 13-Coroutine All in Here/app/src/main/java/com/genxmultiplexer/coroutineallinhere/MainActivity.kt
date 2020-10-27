package com.genxmultiplexer.coroutineallinhere

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.coroutineallinhere.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModelClass
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModelClass::class.java)
//        viewModel.getUserData()
        binding.myViewHolder=viewModel
        binding.lifecycleOwner = this



//        viewModel.userLiveData.observe(this, Observer {myUser->
//            myUser.forEach{
//
//
//                binding.texviewId.text= it.name
//
//            }
//        })

        viewModel.autoUserLiveData.observe(this, Observer {
            if (it != null) {
                for (index in it){
                    binding.texviewId.text= index
                }
            }

        })


/*
        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MYTAG", "Calculation started")
            val stact1 = async(IO) {
                viewModel.getStock1()
            }
            val stact2 = async(IO)  {
                viewModel.getStock2()
            }
            val stact3 = async(IO)  {
                viewModel.getStock3()
            }
            val stact4 = async(IO)  {
                viewModel.getStock4()
            }
            val totalStack = stact1.await() + stact2.await() + stact3.await() + stact4.await()

            Log.i("MYTAG", "Total Stack=$totalStack")

        }

 */
    }
}