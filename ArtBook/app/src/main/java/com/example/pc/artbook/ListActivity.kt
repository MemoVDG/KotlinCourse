package com.example.pc.artbook

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var intent = intent
        var hashMapPinturas = HashMap<String,ByteArray>()
        if(intent.getStringExtra("PhotoActivity") == "1"){
            Toast.makeText(applicationContext,"Agregado correctament",Toast.LENGTH_SHORT).show()
        }

        //Despelagmos la informacion de la BD en el listView
        try{
            var database = this.openOrCreateDatabase("Pinturas",Context.MODE_PRIVATE,null)
            database.execSQL("CREATE TABLE IF NOT EXISTS pinturas(name VARCHAR,images BLOB)")
            var cursor = database.rawQuery("SELECT * FROM pinturas",null)
            var indexName = cursor.getColumnIndex("name")
            var indexImage = cursor.getColumnIndex("images")

            while (cursor.moveToNext()){
                hashMapPinturas.put(cursor.getString(indexName),cursor.getBlob(indexImage))
                cursor.moveToNext()
            }
            cursor!!.close()

            for ((key, value) in hashMapPinturas) {
                Log.e("HashMap","$key = $value")
            }
        }catch (e:Exception){

        }
    }


    //-------------------Menu(los tres puntitos de la barra de arriba)--------------------------
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_art,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.add_art){
            val intent = Intent(this,PhotoActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
    //------------------------------------FIN MENU------------------------------------------------
}
