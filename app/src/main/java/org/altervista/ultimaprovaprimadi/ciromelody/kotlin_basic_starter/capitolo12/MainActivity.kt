package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo12

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(),
    CrimeListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_capitolo12)

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_capitolo12)

        if (currentFragment == null) {
            val fragment = CrimeListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_capitolo12, fragment)
                .commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_capitolo12, fragment)
            .addToBackStack(null)
            .commit()
    }
}
