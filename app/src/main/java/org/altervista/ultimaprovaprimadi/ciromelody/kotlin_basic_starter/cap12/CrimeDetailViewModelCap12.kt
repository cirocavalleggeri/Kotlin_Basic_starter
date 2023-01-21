package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeRepository
import java.util.*

class CrimeDetailViewModelCap12() : ViewModel() {

    private val crimeRepository = CrimeRepositoryCap12.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData: LiveData<Crime?> =
        Transformations.switchMap(crimeIdLiveData) { crimeId ->
            crimeRepository.getCrime(crimeId)
        }

    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId
    }


}