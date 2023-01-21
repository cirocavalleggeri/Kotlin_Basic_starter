package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}