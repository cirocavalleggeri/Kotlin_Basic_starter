package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase

import androidx.lifecycle.ViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeRepository

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}