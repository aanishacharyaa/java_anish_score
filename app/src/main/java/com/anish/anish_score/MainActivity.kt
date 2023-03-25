/**
 * // Name: Anish Acharya
 * Student Number: A00263391
 * This is the main activity of the Anish Score app
 * It displays scores for two teams and allows users to increase or decrease score based on selected
 */

package com.anish.anish_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {

    // Views for team scores, buttons and radio group
    private lateinit var tvTeam1Score: TextView
    private lateinit var tvTeam2Score: TextView
    private lateinit var increaseBtn: Button
    private lateinit var decreaseBtn: Button
    private lateinit var toggleButton: ToggleButton
    private lateinit var radioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Assign views to corresponding variables
        tvTeam1Score = findViewById(R.id.tv_team_1_score)
        tvTeam2Score = findViewById(R.id.tv_team_2_score)
        increaseBtn = findViewById(R.id.increaseBtn)
        decreaseBtn = findViewById(R.id.decreaseBtn)
        toggleButton = findViewById(R.id.tg_1)
        radioGroup = findViewById(R.id.rg)

        // Set the default value for the radio group
        radioGroup.check(R.id.rd_1)

        // Set the default score to 0 for both teams
        tvTeam1Score.text = "0"
        tvTeam2Score.text = "0"

        val toggleButton = findViewById<ToggleButton>(R.id.toggle_button)
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Set dark theme
                layout.setBackgroundColor(Color.BLACK)
                textView.setTextColor(Color.WHITE)
            } else {
                // Set light theme
                layout.setBackgroundColor(Color.WHITE)
                textView.setTextColor(Color.BLACK)
            }
        }


        // Increase button logic
        increaseBtn.setOnClickListener {
            // Get the id of the selected radio button in the radio group
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                // Get the value of the selected radio button
                val selectedValue = findViewById<RadioButton>(selectedId).text.toString().toInt()
                if (toggleButton.isChecked) {
                    // If toggle button is on, increase team 2 score
                    val currentScore = tvTeam2Score.text.toString().toInt()
                    tvTeam2Score.text = (currentScore + selectedValue).toString()

                } else {
                    // If toggle button is off, increase team 1 score
                    val currentScore = tvTeam1Score.text.toString().toInt()
                    tvTeam1Score.text = (currentScore + selectedValue).toString()
                }
            }
        }

        // Decrease button logic
        decreaseBtn.setOnClickListener {
            // Get the id of the selected radio button in the radio group
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                // Get the value of the selected radio button
                val selectedValue = findViewById<RadioButton>(selectedId).text.toString().toInt()
                if (toggleButton.isChecked) {
                    // If toggle button is on, decrease team 2 score if the score is not negative
                    val currentScore = tvTeam2Score.text.toString().toInt()
                    if (currentScore >= selectedValue) {
                        tvTeam2Score.text = (currentScore - selectedValue).toString()
                    }
                } else {
                    // If toggle button is off, decrease team 1 score if the score is not negative
                    val currentScore = tvTeam1Score.text.toString().toInt()
                    if (currentScore >= selectedValue) {
                        tvTeam1Score.text = (currentScore - selectedValue).toString()
                    }
                }
            }
        }
    }
}
