package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeListFragmentCap11

class RoomDatabase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= CrimeListFragmentCap11.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
}