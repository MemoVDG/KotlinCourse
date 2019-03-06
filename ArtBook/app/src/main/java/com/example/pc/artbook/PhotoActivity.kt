package com.example.pc.artbook

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_photo.*
import java.io.ByteArrayOutputStream
import java.util.jar.Manifest

class PhotoActivity : AppCompatActivity() {

    var imageSelected:Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

    }


    fun saveData(view:View){
        if(edTPhotoName.text.isNotEmpty() && imageSelected != null){

            val nameImagen = edTPhotoName.text.toString()
            Toast.makeText(applicationContext,"No Empty",Toast.LENGTH_SHORT).show()
            //Convertimos la imagen a un tipo de formato que se pueda guardar en SQL
            val arrayImage = ByteArrayOutputStream()
            imageSelected!!.compress(Bitmap.CompressFormat.PNG,50,arrayImage)
            var byteImage = arrayImage.toByteArray()


            try{

                //Creamod la BD
                var dataBase = this.openOrCreateDatabase("Pinturas",Context.MODE_PRIVATE,null)
                dataBase.execSQL("DROP TABLE pinturas")
                dataBase.execSQL("CREATE TABLE IF NOT EXISTS pinturas(name VARCHAR,images BLOB)")

                val sql = "INSERT INTO pinturas(name,images) VALUES (?,?)"
                val statement = dataBase.compileStatement(sql)
                statement.bindString(1,nameImagen)
                statement.bindBlob(2,byteImage)
                statement.execute()
                Log.e("Correct","OK")

            }catch (e:Exception){
                Log.e("Correct","NO OK")
                e.printStackTrace()
            }
        }else{
            Toast.makeText(applicationContext,"Introduce la informacion faltante",Toast.LENGTH_SHORT).show()
        }

        val intent = Intent(applicationContext,ListActivity::class.java)
        intent.putExtra("PhotoActivity","1")
        startActivity(intent)

    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun selectPhoto(view: View){
        //Si el permiso de READ_EXTERNAL_STORAGE no esta aun concedido, entra en el IF
        if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            //Funcion para hacer la peticion de los permisos, siempre se le debe de asignar un
            //CODIGO con el cual se va a IDENTIFICAR mas adelante esa peticion de permiso
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),2)
        }else{
            //En caso de que el permiso ya haya sido consedido
            //Creamos nuestro intent hacia la galeria
            val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
       //Pasamoe el codigo de identificacion que se le asigno arriba a esta peticion
        if(requestCode == 2){
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                val intent = Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent,1)            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    //-----------------PERMISO CONCEDIDO-----------------------------------
    //Una vez que el permiso ya fue concedido, se realiza esta funcion en la cual
    //se obtiene lo que selecciono el usuario, en este caso la imagen y se mete en el btnImageView
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){
            val image = data.data
            //Lo metemos en un try/catch en dado caso de que el usuario en lugar de seleccionar una imagen
            //haya seleccionado algun archio o le haya dando cancelar a la accion

            try{
                imageSelected = MediaStore.Images.Media.getBitmap(this.contentResolver,image)
                imageButton.setImageBitmap(imageSelected)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
