package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.capitolo13.Crime
@Database(entities = [ Crime::class ], version=1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {

    abstract fun crimeDao(): CrimeDao
}