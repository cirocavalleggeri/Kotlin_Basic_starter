package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo10.criminalintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_capitolo10)

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_capitolo10)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_capitolo10, fragment)
                .commit()
        }
    }
}
