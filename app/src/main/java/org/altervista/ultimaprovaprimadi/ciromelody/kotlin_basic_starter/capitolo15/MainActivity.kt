package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo15

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import java.util.UUID

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_capitolo15)

        val currentFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_capitolo15)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container_capitolo15, fragment)
                .commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_capitolo15, fragment)
            .addToBackStack(null)
            .commit()
    }
}
