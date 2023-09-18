package com.example.project_wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project_wordle.FourLetterWordList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i])
                result += "0"
            else if (guess[i] in wordToGuess)
                result += "+"
            else
                result += "X"
        }
        return result
    }
}