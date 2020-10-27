package com.genxmultiplexer.livedatawithdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.livedatawithdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(ViewModelClass::class.java)
        binding.lifecycleOwner=this
        binding.myViewModel=viewModel


    }
}