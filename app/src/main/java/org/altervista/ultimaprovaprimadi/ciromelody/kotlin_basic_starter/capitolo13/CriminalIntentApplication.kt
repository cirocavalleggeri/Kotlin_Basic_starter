package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13

import android.app.Application

class CriminalIntentApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}