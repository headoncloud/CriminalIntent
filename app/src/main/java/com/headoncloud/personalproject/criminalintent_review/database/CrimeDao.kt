package com.headoncloud.personalproject.criminalintent_review.database

import androidx.room.Dao
import androidx.room.Query
import com.headoncloud.personalproject.criminalintent_review.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM Crime")
    fun getAllCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM Crime WHERE id= (:id)")
    suspend fun getCrime(id: UUID): Crime
}