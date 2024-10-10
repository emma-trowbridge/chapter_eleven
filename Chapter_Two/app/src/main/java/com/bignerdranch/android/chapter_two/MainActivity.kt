package com.bignerdranch.android.chapter_two

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar //added this for Snackbar



class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    //lateinit' allows initializing a not-null property outside of a constructor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener {
            Snackbar.make( //switched from Toast.makeText to Snackbar.make(
                it, //changed "this", to "it" - makes Snackbar anchor properly, doesn't work with "this"
                R.string.correct,
                Snackbar.LENGTH_LONG //duration, changed to Snackbar
            )
                .show()
        }

        falseButton.setOnClickListener { //made the same changes for false button:
            Snackbar.make(
                it,
                R.string.incorrect,
                Snackbar.LENGTH_LONG
            )
                .show()
        }
    }
}