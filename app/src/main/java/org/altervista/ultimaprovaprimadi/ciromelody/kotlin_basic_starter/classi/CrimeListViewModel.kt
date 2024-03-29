package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi

import androidx.lifecycle.ViewModel

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()
    init {
        for(i in 0 until 100){
            val crime =Crime()
            crime.title="Crime #$i"
            crime.isSolved=i % 2 ==0
            crime.isRequiresPolice=i % 3 ==0
            crimes+=crime
        }
    }
}