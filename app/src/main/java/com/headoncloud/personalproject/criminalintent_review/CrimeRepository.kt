package com.headoncloud.personalproject.criminalintent_review

import android.content.Context
import androidx.room.Room
import com.headoncloud.personalproject.criminalintent_review.database.CrimeDatabase
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context){
    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset("crime-database")
        .build()

    fun getAllCrimes() = database.crimeDao().getAllCrimes()

    suspend fun getCrime(id: UUID): Crime = database.crimeDao().getCrime(id)

    companion object{
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context){
            if(INSTANCE == null){
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository{
            return INSTANCE ?:
                throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}