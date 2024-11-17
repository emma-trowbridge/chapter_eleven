package com.bignerdranch.android.chapter_thirteen

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.chapter_thirteen.database.CrimeDatabase
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context){

    private val database:CrimeDatabase= Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset(DATABASE_NAME)
        .build()

//  suspend fun getCrimes():List<Crime> = database.crimeDAO().getCrimes()
    fun getCrimes(): Flow<List<Crime>> = database.crimeDAO().getCrimes() //changed to <List>
    suspend fun getCrime(id:UUID):Crime = database.crimeDAO().getCrime(id)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE
                ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}