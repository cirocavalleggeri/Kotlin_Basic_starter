package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo11.criminalintent
import android.app.Application
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.*

class CriminalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}