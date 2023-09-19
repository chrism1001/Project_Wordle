package com.example.project_wordle

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var guesses = 3
    private var gameState = true
    private val word = FourLetterWordList.getRandomFourLetterWord()

    @SuppressLint("MissingInflatedId")
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
        val input = findViewById<TextInputEditText>(R.id.inputedit) // cant figure out how to get
                                                                    // the text the user inputted

        button.setOnClickListener {
            Log.d("success", input.text.toString())
            Log.d("success", word)
            while (guesses >= 0 && gameState) {
                if (input.text.toString().uppercase() == word || guesses == 0) {
                    gameState = false
                    break
                }
                if (guesses == 3) {
                    guess1.text = input.text.toString().uppercase()
                    answer1.text = checkGuess(guess1.text.toString().uppercase(), word)
                } else if (guesses == 2) {
                    guess2.text = input.text.toString().uppercase()
                    answer2.text = checkGuess(guess2.text.toString().uppercase(), word)
                } else {
                    guess3.text = input.text.toString().uppercase()
                    answer3.text = checkGuess(guess3.text.toString().uppercase(), word)
                }

                input.text?.clear()
                guesses--
            }

            if (!gameState) {
                Toast.makeText(it.context, "You Won!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(it.context, "You Lost!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            result += if (guess[i] == wordToGuess[i]) {
                "O"
            } else if (guess[i] in wordToGuess) {
                "+"
            } else {
                "X"
            }
        }
        return result
    }
}