package com.example.pc.listviewlandmarkproyect

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementar un listView
        //Creamos el Array de elementos, lo llenamos y luego creamos el
        //Adapter: recibe el
        //      contexto->Normalmente es this
        //      tipo de list->Se puede usar uno ya definido o crear un layout
        //      array-> El array en donde se encuentran los elementos a mostrar
        //Una vez que ya se inicializo el adapter se le pasa con el id que tienen en el XML

        var arrayPlaces = ArrayList<String>()
        arrayPlaces = arrayListOf("Cholula","Prismas Basalticos","Nevado de Toluca","Bacalar")
        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayPlaces)
        lstView.adapter = arrayAdapter


        var cholula = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.cholula)
        var primas = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.prismas)
        var nevado = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.nevado)
        var bacalar = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.bacalar)

        var arrayImages = ArrayList<Bitmap>()

        arrayImages = arrayListOf(cholula,primas,nevado,bacalar)


        var hashMap = HashMap<String,Bitmap>()

        hashMap = hashMapOf("Cholula" to cholula,
                "Primas Basalticos" to primas,
                "Nevado de Toluca" to nevado,
                "Bacalar" to bacalar)


        var arrayDescription = ArrayList<String>()
        arrayDescription.add("La Gran Pirámide de Cholula o Tlachihualtépetl es el basamento piramidal más grande del mundo con 400 metros por lado.\u200B Es también la pirámide más grande en volumen con 4.500.000 m³, aunque no en altura: tiene 65 m de alto mientras que la Gran Pirámide de Giza en Egipto tiene una altura de 146 m")
        arrayDescription.add("Son una de las 13 maravillas naturales de México, son  formaciones rocosas talladas por el agua durante millones de años, logrando así una estructura geométrica perfecta también según estudios se dice son el resultado del enfriamiento lento de la lava hace varios millones de años. De esta manera se formaron las columnas de basalto de 5 ó 6 caras en posición vertical")
        arrayDescription.add("El Nevado de Toluca, aunque aún referido como \"Xinantécatl\", es un volcán mexicano ubicado en el Estado de México, entre los valles de Toluca y Tenango. Se localiza a 22 km al suroeste de Toluca, Estado de México. ")
        arrayDescription.add("Bacalar es una población del estado mexicano de Quintana Roo, situada en el sur de su territorio a unos 40 km al norte de la capital, Chetumal. Desde el 2 de febrero de 2011 es cabecera del municipio de Bacalar.")

        //Le agregagamo un onItemClickListener al listView para detectar
        //en que elemento se dio click y sea el que se pase a la otra vista
        //Ese elemento viene determinado por la variable "i"
        lstView.onItemClickListener = AdapterView.OnItemClickListener{ adapterView, view, i, l ->
            val intent = Intent(applicationContext,InfoActivity::class.java)
            intent.putExtra("Title",arrayPlaces[i])
            intent.putExtra("Description",arrayDescription[i])

            //Obtenemos la imagen y luego la seteamos en la que seria la variable
            //"global" de la clase GlobalImage
            var imagen = arrayImages[i]
            var chosen = GlobalImage.Chosen
            chosen.chosenImage = imagen


            startActivity(intent)
        }

    }
}
