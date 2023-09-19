package com.example.project_wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.project_wordle.FourLetterWordList
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    val guesses = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val guess1 = findViewById<TextView>(R.id.guessid1)
        val guess2 = findViewById<TextView>(R.id.guessid2)
        val guess3 = findViewById<TextView>(R.id.guessid3)
        val answer1 = findViewById<TextView>(R.id.answerid1)
        val answer2 = findViewById<TextView>(R.id.answerid2)
        val answer3 = findViewById<TextView>(R.id.answerid3)
        val input = findViewById<TextInputLayout>(R.id.textInputLayout1)

        button.setOnClickListener {

        }
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