package com.example.memo.layoutsection

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Shared preferences

        var age = 30
        //Inicializamos el shared preferencies y le decimos el paquete del cual se guardara la informacion
        //El modo en el que se guardara, en este caso en privado
        val sharedPreferences = this.getSharedPreferences("com.example.memo.layoutsection",android.content.Context.MODE_PRIVATE)


        sharedPreferences.edit().putInt("ageUser",age)

        age = 31

        //Recuperamos el sharedPreference, con el id que se le dio, sino es la primera vez que se corre la app
        //Y no tiene ni un valor se de pone un 0 por defecto
        sharedPreferences.getInt("ageUser",0)

        //Eliminar el sharedPreference
        sharedPreferences.edit().remove("ageUser")
    }


    fun goSecond(view: View){
      if(editText.text.toString().isNotEmpty()){
          var intent = Intent(applicationContext,SecondActivity::class.java)
          intent.putExtra("Info",editText.text.toString())
          startActivity(intent)
      }else{
          Snackbar.make(view,"Feed me with your info!!",Snackbar.LENGTH_SHORT).show()
      }
    }
}
