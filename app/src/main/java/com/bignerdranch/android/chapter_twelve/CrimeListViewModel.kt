package com.bignerdranch.android.chapter_twelve

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel :ViewModel() {

    val crimes = mutableListOf<Crime>()
    private val crimeRepository = CrimeRepository.get()

    init {
        Log.d(TAG, "init starting")
        viewModelScope.launch {

            Log.d(TAG, "coroutine launched")
//                delay(5000)
//
//        for (i in 0 until 100) {
//            val crime = Crime(
//                id = UUID.randomUUID(),
//                title = "Crime #$i",
//                date = Date(),
//                isSolved = i % 2 == 0
//            )
//
//            crimes += crime
//            }
            crimes += loadCrimes()
            Log.d(TAG, "Loading crimes finished")

        }
    }

    suspend fun loadCrimes(): List<Crime> {
        /*val result = mutableListOf<Crime>()

        delay(5000) //5 second delay for loading

        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0
            )
            result += crime
        }
        return result*/

        return crimeRepository.getCrimes()
    }
}