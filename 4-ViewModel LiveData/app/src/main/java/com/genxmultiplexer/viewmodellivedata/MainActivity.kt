package com.genxmultiplexer.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.viewmodellivedata.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:ViewModelClass
    private lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(ViewModelClass::class.java)

        viewModel.countData.observe(this, Observer {
            binding.textViewCounterId.text=it.toString()
        })

        binding.buttonCounterId.setOnClickListener{
            viewModel.setCount()

        }


    }



}