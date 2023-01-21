package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.CrimeFragmentCap12
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.CrimeListFragmentCap12

import java.util.*

class RoomDatabaseCap12 : AppCompatActivity(), CrimeListFragmentCap12.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_databasecap12)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= CrimeListFragmentCap12.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        Toast.makeText(this,"{UUID} onCrimeSelected(crimeId: UUID)", Toast.LENGTH_LONG).show()
        val fragment = CrimeFragmentCap12.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}