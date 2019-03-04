package com.example.pc.listviewlandmarkproyect

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        //Obtenemos el Titulo y la descripcion que fueron pasadas por el intent
        //Hacia el activity y los ponemos en la vista
        var intent = intent
        var title =intent.getStringExtra("Title")
        var description = intent.getStringExtra("Description")
        txtViewTitle.text = title
        txtViewDescription.text = description

        //Obtenemos la imagen, ya que en el activity anterior se le asigno un valor a la variable
        //Entonces ahora se puede obtener, desde esta clase con con la clase GlobalImage
        var chosen = GlobalImage.Chosen
        var selectedImagen  = chosen.returnImagen()
        imgView.setImageBitmap(selectedImagen)
    }
}
