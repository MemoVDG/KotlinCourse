package com.example.pc.catchthekenny

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var score = 0
    var flag = false
    var imageArray = ArrayList<ImageView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializamos el array con las imagenes

        imageArray = arrayListOf(choper00,choper01,choper10,choper11)
    }


    fun startGame(view: View){
        flag = true
        btnStart.isEnabled = false
        object:CountDownTimer(20000,100){
            override fun onFinish() {
                //Activamos el boton de nuevo para que se pueda volver a jugar
                btnStart.isEnabled = true
                txtViewTime.text = "Finish"

                //Creamos un AlertDialog para pder mostrar el puntaje al usuario y al final reiniciamos
                //el puntaje para el siguiente jugador
                var dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("Fin del Juego")
                dialog.setMessage("Tu puntaje es: $score")
                dialog.setNeutralButton("OK"){dialog,which->
                    Toast.makeText(applicationContext,";)",Toast.LENGTH_SHORT).show()
                }

                dialog.show()
                //Ponemos el score en 0
                score = 0
                txtViewScore.text = "Score: 0"
                flag = false



            }
            override fun onTick(p0: Long) {
                txtViewTime.text = "Time: "+ p0/1000
                moveRandom()

            }
        }.start()
    }

    //Generamos un numero randon para que aparezca o desaparezca el personaje
    //Y  apartir de ese numero es la posicion en la que se muestra el personaje
    fun moveRandom(){
        var m = 0
        var random = Random.nextInt(0,4)
        when(random){
            0->{
                choper00.visibility = View.VISIBLE
                choper01.visibility = View.INVISIBLE
                choper10.visibility = View.INVISIBLE
                choper11.visibility = View.INVISIBLE
            }
            1->{
                choper00.visibility = View.INVISIBLE
                choper01.visibility = View.VISIBLE
                choper10.visibility = View.INVISIBLE
                choper11.visibility = View.INVISIBLE
            }
            2->{
                choper00.visibility = View.INVISIBLE
                choper01.visibility = View.INVISIBLE
                choper10.visibility = View.VISIBLE
                choper11.visibility = View.INVISIBLE
            }
            3->{
                choper00.visibility = View.INVISIBLE
                choper01.visibility = View.INVISIBLE
                choper10.visibility = View.INVISIBLE
                choper11.visibility = View.VISIBLE
            }
        }

    }

    //Detectamos el click en la imagen y

    fun increaseScore(view:View){
        if(flag){
            score++
            txtViewScore.text = "Score: $score"
        }

    }
}
