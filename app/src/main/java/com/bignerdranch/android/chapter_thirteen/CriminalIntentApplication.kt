package com.bignerdranch.android.chapter_thirteen

import android.app.Application

class CriminalIntentApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}