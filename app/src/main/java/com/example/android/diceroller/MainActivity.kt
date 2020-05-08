package com.example.android.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {rollDice()}

        val countUpButton: Button = findViewById(R.id.count_button)
        countUpButton.setOnClickListener {incrementCount()}

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener {resetCount()}
    }

    private fun rollDice() {
        val randomInt = (1..6).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()
    }

    private fun incrementCount() {
        val resultText: TextView = findViewById(R.id.result_text)

        // If text is the default "Game On" set that text to 1.
        if (resultText.text == "Game On") {
            resultText.text = "1"
        } else {
            // Otherwise, increment the number up to 6.
            // The text value in resultText.text is an instance of the CharSequence class;
            // it needs to be converted to a String object before it can be converted to an int.
            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    private fun resetCount() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }

}
