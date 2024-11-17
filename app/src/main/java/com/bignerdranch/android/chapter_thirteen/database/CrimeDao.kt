package com.bignerdranch.android.chapter_thirteen.database

import androidx.room.Dao
import androidx.room.Query
import com.bignerdranch.android.chapter_thirteen.Crime
import kotlinx.coroutines.flow.Flow
import java.util.UUID


@Dao
interface CrimeDao {

    @Query("Select * From crime")
    fun getCrimes(): Flow<List<Crime>> //changed to <List>

    @Query("Select * From crime Where id=(:id)")
    suspend fun getCrime(id:UUID):Crime

}

