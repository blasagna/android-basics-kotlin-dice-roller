package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // NOTE: android auto assigns resource IDs R.type.name
        val rollButton: Button = findViewById(R.id.button)

        // Declare a lambda
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            val leftResultText: TextView = findViewById(R.id.textViewLeft)
            rollDice(leftResultText)
            val rightResultText: TextView = findViewById(R.id.textViewRight)
            rollDice(rightResultText)
        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(resultText: TextView) {
        // Create a roll a dice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the displayed dice roll result
        resultText.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        // Get a random element in the sequence [1, numSides], inclusive
        return (1..numSides).random()
    }
}