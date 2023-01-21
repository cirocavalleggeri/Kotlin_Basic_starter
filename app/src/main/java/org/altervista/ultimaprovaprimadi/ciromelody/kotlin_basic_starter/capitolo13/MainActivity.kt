package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main_capitolo13.*
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.R
import java.util.*

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_capitolo13)

        val fm: FragmentManager = supportFragmentManager
        val currentFragment = fm.findFragmentById(R.id.fragment_container_capitolo13)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            fm.beginTransaction()
                .add(R.id.fragment_container_capitolo13, fragment)
                .commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_capitolo13, fragment)
            .addToBackStack(null)
            .commit()
    }
}
