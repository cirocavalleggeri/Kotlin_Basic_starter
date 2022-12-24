package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeFragment
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.CrimeListFragment

class RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val currentFragment =supportFragmentManager.findFragmentById(R.id.fragment_container)
        if(currentFragment==null){
            val fragment= CrimeListFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment).commit()
        }
    }
}