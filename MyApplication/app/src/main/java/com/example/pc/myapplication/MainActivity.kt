package com.example.pc.myapplication

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //Array
        val myArray = arrayOfNulls<String>(4)

        myArray[0] = "Memo"
        myArray[1] = "Vara"
        myArray[2] = "De"
        myArray[3] = "Gante"

        var mySecondArray = arrayOf(10,20,20)

        println(mySecondArray.size)
        mySecondArray.set(0,100)
        mySecondArray.get(2)


        //List

        var myList = ArrayList<String>()

        myList.add("Memo")
        myList.remove("Kotlin")
        myList.add(0,"Lost")

        //Set, no permite tener datos duplicados


        val mySet = HashSet<String>()

        mySet.






        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
