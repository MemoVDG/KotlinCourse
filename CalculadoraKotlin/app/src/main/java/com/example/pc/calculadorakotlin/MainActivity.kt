package com.example.pc.calculadorakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun suma(view:View){

        if(edtFirstNumber.text.toString().isNotBlank() && edtSecondNumber.text.toString().isNotBlank()){
            txtVResult.text = ((edtFirstNumber.text.toString()).toInt() + (edtSecondNumber.text.toString()).toInt()).toString()
        }else{
            Toast.makeText(this,"Introduce el numero plis",Toast.LENGTH_SHORT).show()
        }
    }

    fun resta(view:View){
        if(edtFirstNumber.text.toString().isNotBlank() && edtSecondNumber.text.toString().isNotBlank()){
            txtVResult.text = ((edtFirstNumber.text.toString()).toInt() - (edtSecondNumber.text.toString()).toInt()).toString()
        }else{
            Toast.makeText(this,"Introduce el numero plis",Toast.LENGTH_SHORT).show()
        }
    }

    fun multiplicacion(view:View){
        if(edtFirstNumber.text.toString().isNotBlank() && edtSecondNumber.text.toString().isNotBlank()){
            txtVResult.text = ((edtFirstNumber.text.toString()).toInt() * (edtSecondNumber.text.toString()).toInt()).toString()
        }else{
            Toast.makeText(this,"Introduce el numero plis",Toast.LENGTH_SHORT).show()
        }
    }

    fun division(view:View){
        if(edtFirstNumber.text.toString().isNotBlank() && edtSecondNumber.text.toString().isNotBlank()){
            txtVResult.text = ((edtFirstNumber.text.toString()).toInt() / (edtSecondNumber.text.toString()).toInt()).toString()
        }else{
            Toast.makeText(this,"Introduce el numero plis",Toast.LENGTH_SHORT).show()
        }
    }

}
