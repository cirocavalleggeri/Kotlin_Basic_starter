package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase

import android.app.Application
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeRepository
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