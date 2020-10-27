package com.genxmultiplexer.databinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.databinding.DataBindingUtil
import com.genxmultiplexer.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.submitButtonId.setOnClickListener {
            setMyText()
        }

        binding.progressBarStartButtonId.setOnClickListener {
            setUpMyProgressBar()
        }


    }

    private fun setUpMyProgressBar() {
        binding.apply {
            if (progressCircularId.visibility == View.GONE) {
                progressCircularId.visibility = View.VISIBLE

                progressBarStartButtonId.text = "Stop"
            } else {
                progressCircularId.visibility = View.GONE
                progressBarStartButtonId.text = "Start"
            }
        }
    }


    //Here apply is scoping function it used for remove common text in a scope
    private fun setMyText() {
        binding.apply {
            messageTextViewId.text = usernameEditTextId.text
        }
    }
}