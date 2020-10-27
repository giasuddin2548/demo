package com.genxmultiplexer.retrofitusingmvvm.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*

fun Context.myToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show() {
    visibility = View.VISIBLE
}

fun ProgressBar.hide() {
    visibility = View.GONE
    visibility = View.INVISIBLE
}