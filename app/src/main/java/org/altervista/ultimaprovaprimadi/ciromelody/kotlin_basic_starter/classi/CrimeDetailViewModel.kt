package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeRepository
import java.util.*

class CrimeDetailViewModel() : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        Transformations.switchMap(crimeIdLiveData) { crimeId ->
            crimeRepository.getCrime(crimeId)
        }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }


}