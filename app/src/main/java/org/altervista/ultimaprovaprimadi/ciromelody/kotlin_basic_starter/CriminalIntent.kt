package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeFragment

class CriminalIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criminal_intent)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.id_criminalintent)
        if(currentFragment==null){
            val fragment=CrimeFragment()
            supportFragmentManager.beginTransaction().add(R.id.id_criminalintent,fragment).commit()
        }


    }
}