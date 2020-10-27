package com.genxmultiplexer.navigationarchitechture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.genxmultiplexer.navigationarchitechture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this


//        val navController = Navigation.findNavController(binding.fragment)
//        NavigationUI.setupActionBarWithNavController(this, navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(Navigation.findNavController(binding.fragment), null)
//    }
}
