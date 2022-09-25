package com.example.diceroller

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        val leftResultText: TextView = findViewById(R.id.textViewLeft)
        val leftResultImage: ImageView = findViewById(R.id.imageViewLeft)

        val rightResultText: TextView = findViewById(R.id.textViewRight)
        val rightResultImage: ImageView = findViewById(R.id.imageViewRight)

        // Declare a lambda
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            rollDice(leftResultText, leftResultImage)
            rollDice(rightResultText, rightResultImage)
        }

        // Roll dice on launch
        rollDice(leftResultText, leftResultImage)
        rollDice(rightResultText, rightResultImage)
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice(resultText: TextView, resultImage: ImageView) {
        // Create a roll a dice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the displayed dice roll result
        resultText.text = diceRoll.toString()
        val diceImage = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        resultImage.setImageResource(diceImage)

        // Update content description for a screen reader to read aloud
        resultImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        // Get a random element in the sequence [1, numSides], inclusive
        return (1..numSides).random()
    }
}