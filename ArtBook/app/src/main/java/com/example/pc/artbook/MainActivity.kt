package com.example.pc.artbook

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creamos la BD, debemos de manejar un try/catch blog para evitar errores

        try{
            //Creamos la BD
            //-Primera parametro:Nombre de la BD
            //-Segundo: El contexto, en este caso es privado porque queremos que solo nosotros podamos
            //accesar a la BD
            var dataBase = this.openOrCreateDatabase("Musicos", Context.MODE_PRIVATE,null)
            //--------------------Cramos e insertamos en la BD usando SQL---------------------------
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS musicos (name VARCHAR, age INT(2))")
            //dataBase.execSQL("INSERT INTO musicos (name,age) VALUES ('Pedro Picapiedra',34)")
            dataBase.execSQL("INSERT INTO musicos (name,age) VALUES ('Miguel Periño',22)")
            dataBase.execSQL("INSERT INTO musicos (name,age) VALUES ('Jose Miguel',14)")



            //-------------------Actualizar Datos----------------------------------
            //dataBase.execSQL("UPDATE musicos SET name ='Memo' WHERE name='Pedro Picapiedra'")

            //------------------Eliminar datos-------------------------------------
            dataBase.execSQL("DELETE FROM musicos WHERE name='Memo'")

            //-----------------Consultas a la BD-----------------------------------
            //Hacemos la consulta a la BD a partir de un cursos
            var cursor = dataBase.rawQuery("SELECT * FROM musicos",null)
            //Obtenemos los indices de las columas
            var nameIndex = cursor.getColumnIndex("name")
            var ageIndex = cursor.getColumnIndex("age")
            cursor.moveToFirst()
            while (cursor.moveToNext()){
                //Log.e("Name",""+ cursor.getString(nameIndex))
                //Log.e("Age",""+ cursor.getInt(ageIndex))
            }
            //Importante cerrar el cursor para evitar peridades de memoria y errores en uso de la BD en siguientes ocaciones
            cursor!!.close()

            //-------------Consulta por Filtros----------------------------
            var cursorFilter = dataBase.rawQuery("SELECT * FROM musicos WHERE age = 14",null)
            var nameIndexFilter = cursorFilter.getColumnIndex("name")
            var ageIndexFilter = cursorFilter.getColumnIndex("age")
            cursorFilter.moveToFirst()
            while (cursorFilter.moveToNext()){
                Log.e("Name",""+ cursorFilter.getString(nameIndexFilter))
                Log.e("Age",""+ cursorFilter.getInt(ageIndexFilter))
            }
            //Importante cerrar el cursor para evitar peridades de memoria y errores en uso de la BD en siguientes ocaciones
            cursorFilter!!.close()

        }catch (e:Exception){
            e.printStackTrace()

        }
    }

    fun goToArt(view: View){
        var intent = Intent(this,ListActivity::class.java)
        startActivity(intent)
    }
}
