package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo11.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()
}