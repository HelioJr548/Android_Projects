package com.example.sqlite

import android.support.v7.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
//            CRIAR DB
            val bd = openOrCreateDatabase("copa", MODE_PRIVATE, null)


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}