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
    var tests = arrayOf("MainActivity","ButtonActivity","ModelViewActivity","Fragment","CriminalIntent","RecyclerView"
                              ,"RecyclerViewAlternate","RecyclerViewAlternateSerious"
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
            startActivity(intent)
                    finish()
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