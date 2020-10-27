package com.genxmultiplexer.recyclerviewmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.genxmultiplexer.recyclerviewmvvm.R
import com.genxmultiplexer.recyclerviewmvvm.databinding.ActivityMainBinding
import com.genxmultiplexer.recyclerviewmvvm.network.Repository
import com.genxmultiplexer.recyclerviewmvvm.network.StudentDaoInterface
import com.genxmultiplexer.recyclerviewmvvm.network.StudentDatabase

class MainView : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = StudentDatabase.invoke(application).daoStudentInterface
        val repository = Repository(dao)
        val factory = ViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.studentList.observe(this, Observer {
            Log.d("DATA","$it")
        })

    }
}