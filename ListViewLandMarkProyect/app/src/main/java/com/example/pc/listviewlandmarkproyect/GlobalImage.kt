package com.example.pc.listviewlandmarkproyect

import android.graphics.Bitmap

class GlobalImage {

    //Esto es como declarar una variable global
    companion object Chosen {
        var chosenImage:Bitmap? = null
        fun returnImagen():Bitmap{
            return chosenImage!!
        }
    }
}