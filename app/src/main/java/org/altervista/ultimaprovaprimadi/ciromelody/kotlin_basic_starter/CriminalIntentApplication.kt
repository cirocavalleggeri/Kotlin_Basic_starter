package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter

import android.app.Application
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12.CrimeRepositoryCap12
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo12.CrimeRepository
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*

class CriminalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo11.criminalintent.CrimeRepository.initialize(this)
        CrimeRepositoryCap12.initialize(this)
        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo12.CrimeRepository.initialize(this)
        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13.CrimeRepository.initialize(this)
        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo14.CrimeRepository.initialize(this)
        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo15.CrimeRepository.initialize(this)
        org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo16.CrimeRepository.initialize(this)

    }
}