package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.cap12

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

import java.util.*
import java.util.concurrent.Executors


private const val DATABASE_NAME = "crime-database-prova"

class CrimeRepositoryCap12 private constructor(context: Context) {

    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE Crime "
                        + "ADD COLUMN isRequiresPolice Boolean"
            )
        }
    }

    private val database : CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ) .build()





    private val crimeDao = database.crimeDao()
    private val executor = Executors.newSingleThreadExecutor() //remove before pushing

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    fun addCrime(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(crime)
        }
    } //remove this eventually

    companion object {
        private var INSTANCE: CrimeRepositoryCap12? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepositoryCap12(context)
            }
        }

        fun get(): CrimeRepositoryCap12 {
            return INSTANCE ?:
            throw IllegalStateException("CrimeRepository must be initialized")
        }
    }


}