package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.fragments.CrimeListFragment
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.fragments.CrimeListFragmentCap10

class ConstraintLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= CrimeListFragmentCap10.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
    }
