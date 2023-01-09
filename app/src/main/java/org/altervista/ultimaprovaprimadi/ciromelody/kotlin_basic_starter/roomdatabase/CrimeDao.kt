package org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.altervista.ultimaprovaprimadi.ciromelody.kotlin_basic_starter.roomdatabase.Crime
import java.util.*

@Dao
interface CrimeDao {

    @Query("SELECT * FROM crime")
    fun getCrimes(): LiveData<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    fun getCrime(id: UUID): LiveData<Crime?>

    @Insert
    fun addCrime(crime: Crime) //remove this before pushing
}