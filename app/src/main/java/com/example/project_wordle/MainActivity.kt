package com.example.project_wordle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.project_wordle.FourLetterWordList
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    var guesses = 3
    var gameState = true
    val word = FourLetterWordList.getRandomFourLetterWord()

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
        val input = findViewById<EditText>(R.id.textInputLayout1)

        button.setOnClickListener {
            while (guesses >= 0 && gameState) {
                if (input.text.toString() == word || guesses == 0) {
                    gameState = false
                    break
                }
                if (guesses == 3) {
                    guess1.text = input.text.toString()
                    answer1.text = checkGuess(guess1.text.toString(), word)
                } else if (guesses == 2) {
                    guess2.text = input.text.toString()
                    answer2.text = checkGuess(guess2.text.toString(), word)
                } else {
                    guess3.text = input.text.toString()
                    answer3.text = checkGuess(guess3.text.toString(), word)
                }

                input.text.clear()
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