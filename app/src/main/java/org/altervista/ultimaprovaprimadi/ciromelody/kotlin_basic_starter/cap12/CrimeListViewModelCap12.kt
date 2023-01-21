package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.Crime
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.CrimeRepositoryCap12
import java.util.ArrayList

class CrimeListViewModelCap12 : ViewModel() {
    lateinit var crimes:List<Crime>
    private val crimeRepository = CrimeRepositoryCap12.get()
    val crimeListLiveData = crimeRepository.getCrimes()

  fun caricadati(){
      for(i in 0 until 100){
          val crime =
              org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.classi.Crime()
          crime.title="Crime #$i"
          crime.isSolved=i % 2 ==0
          crime.isRequiresPolice=i % 3 ==0

      }
  }


}