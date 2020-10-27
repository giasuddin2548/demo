package com.genxmultiplexer.customviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.customviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
//    private lateinit var viewModelFectory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
//        viewModelFectory= MainViewModelFactory(100)

//        viewModel= ViewModelProvider(this,viewModelFectory).get(MainViewModel::class.java)
        viewModel= ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.totalData.observe(this, Observer {
            binding.textViewCounterId.text=it.toString()
        })


        binding.buttonAdderId.setOnClickListener{
            viewModel.setTotal(binding.editTextUserValueId.text.toString().toInt())


        }

    }


}