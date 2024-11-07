package com.bignerdranch.android.chapter_eleven

import java.util.Date
import java.util.UUID

data class Crime (
    val id:UUID,
    val title:String,
    val date: Date,
    val isSolved:Boolean
)