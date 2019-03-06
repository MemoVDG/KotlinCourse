package com.example.pc.dailycodechallenges

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_uno.*

class UnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uno)
    }

    fun calcular(view: View){
        var number:Int
        var arrayNumbers = ArrayList<Int>()
        //edTNumber.text.toString().isNotEmpty()? number = (edTNumber.text.toString()).toInt():
        if(edTNumber.text.toString().isNotEmpty() && edtArray.text.toString().isNotEmpty()){
            var number   = (edTNumber.text.toString()).toInt()

            Log.e("Number","$number")
            Log.e("Array","Size:"+arrayNumbers)




        }
    }
}
