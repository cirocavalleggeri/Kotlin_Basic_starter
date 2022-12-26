package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeListFragment
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.fragments.CrimeListFragmentSerious

class RecyclerViewAlternateSerious : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_alternate_serious2)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= CrimeListFragmentSerious.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
}