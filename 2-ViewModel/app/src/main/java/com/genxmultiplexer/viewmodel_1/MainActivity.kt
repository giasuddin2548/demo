package com.genxmultiplexer.viewmodel_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.viewmodel_1.ViewModels.MainViewModel
import com.genxmultiplexer.viewmodel_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        binding.textViewCounterId.text=viewModel.getCurrentPosition().toString()




        binding.buttonCounterId.setOnClickListener{
            binding.textViewCounterId.text=viewModel.getUpdatedPosition().toString()
        }

        binding.buttonAdderId.setOnClickListener{
            val value:Int=binding.editTextUserValueId.text.toString().toInt()

            binding.textViewCounterId.text=viewModel.setTotal(value).toString()
            binding.textViewCounterId.text=viewModel.getTotal().toString()
        }


    }
}