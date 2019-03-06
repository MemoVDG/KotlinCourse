package com.example.pc.dailycodechallenges

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun uno(view: View){
        var intent = Intent(this,UnoActivity::class.java)
        startActivity(intent)
    }
}
