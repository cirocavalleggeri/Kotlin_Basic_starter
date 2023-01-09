package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.CrimeTypeConverters

import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.Crime
//entities è una lista di tabelle in questo caso una,version è la versione del database
//questo cambia quando si modifica una tabella
@Database(entities = [Crime::class], version = 1)
//l\'annotazione <b>TypeConverters</b> serve per dire come convertire i dati da e verso il database
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase : RoomDatabase() {
//CrimeDao fornisce le istruzioni SQL per operare sulle tabelle
  abstract fun crimeDao(): CrimeDao
}