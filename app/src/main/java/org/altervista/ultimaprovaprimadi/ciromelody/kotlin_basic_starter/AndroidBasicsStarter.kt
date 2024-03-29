package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import android.R
import android.app.ListActivity
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class AndroidBasicsStarter : ListActivity() {
    var tests = arrayOf("MainActivity","geoquiz.Two_button_GeoQuiz","capitolo2.Android_and_ModelView_Controller_capitolo_2","capitolo4.Capitolo_4","capitolo5.Capitolo_5","capitolo6.Capitolo_6","ButtonActivity","ModelViewActivity","Fragment","CriminalIntent","RecyclerView"
                              ,"RecyclerViewAlternate","RecyclerViewAlternateSerious","ConstraintLayout","RoomDatabase",
        "RoomDatabaseCap12","capitolo10.criminalintent.MainActivity","capitolo11.criminalintent.MainActivity","capitolo12.MainActivity",
        "capitolo13.MainActivity","capitolo14.MainActivity","capitolo15.MainActivity","capitolo16.MainActivity"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listAdapter = ArrayAdapter(
            this,
            R.layout.simple_list_item_1, tests
        )
    }

    override fun onListItemClick(
        list: ListView, view: View, position: Int,
        id: Long
    ) {
        super.onListItemClick(list, view, position, id)

        val testName = tests[position]
        Toast.makeText(this,"Posizione:"+position+ " "+testName,Toast.LENGTH_SHORT).show()
        try {
            val clazz = Class
                .forName("org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.$testName")

            val intent = Intent(this, clazz)
            intent.putExtra("Username","John Doe")
            intent.putExtra("Orientamento","Landscape")
            var b = Bundle()
            b.putBoolean("isActive", true)
            intent.putExtras(b)
            startActivity(intent)
                  //  finish()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        if (isNetworkAvailable) {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://ultimaprovaprimadi.altervista.org/le-mie-app-android/")
            )
            startActivity(browserIntent)
        }
        super.onBackPressed()
    }

    protected val isNetworkAvailable: Boolean
        protected get() {
            val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
}