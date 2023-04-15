package corg.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo16

import androidx.lifecycle.ViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo16.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo16.CrimeRepository

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }
}