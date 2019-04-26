package edu.washington.magdanat.lifecounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.player_component.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // References to each player
        var playerOne: ConstraintLayout = findViewById(R.id.pOne)
        var playerTwo: ConstraintLayout = findViewById(R.id.pTwo)
        var playerThree: ConstraintLayout = findViewById(R.id.pThree)
        var playerFour: ConstraintLayout = findViewById(R.id.pFour)

        var playerArray = arrayOf(playerOne, playerTwo, playerThree, playerFour)

        var loser: TextView = findViewById(R.id.loser)

        // Set Player Names
        playerOne.playerText.player.text = "Player One"
        playerTwo.playerText.player.text = "Player Two"
        playerThree.playerText.player.text = "Player Three"
        playerFour.playerText.player.text = "Player Four"

        // References to player health
        playerOne.playerText.health.text = "30"
        playerTwo.playerText.health.text = "30"
        playerThree.playerText.health.text = "30"
        playerFour.playerText.health.text = "30"

        // Checks if health is lower is less than zero and declares the loser
        fun weHaveALoser(healthNum : Int, layout: ConstraintLayout) {
            if (healthNum <= 0) {
                val name = layout.playerText.player.text.toString()
                loser.text = name + " LOSES!"
                loser.visibility = View.VISIBLE
            }
        }

        // Used if someone lost the game and health is being reset
        fun removeLoserStatus(healthNum : Int) {
            if (healthNum > 0) {
                loser.text = ""
                loser.visibility = View.INVISIBLE
            }
        }

        // Adds a onClickListener to every layout button
        for (layout in playerArray) {
            for (layout in playerArray) {
                layout.buttons.plus_one.setOnClickListener {
                    var health = layout.playerText.health.text.toString().toInt()
                    health += 1
                    layout.playerText.health.text = health.toString()
                    removeLoserStatus(health)
                }
                layout.buttons.plus_five.setOnClickListener {
                    var health = layout.playerText.health.text.toString().toInt()
                    health += 5
                    layout.playerText.health.text = health.toString()
                    removeLoserStatus(health)
                }
                layout.buttons.minus_one.setOnClickListener {
                    var health = layout.playerText.health.text.toString().toInt()
                    health -= 1
                    layout.playerText.health.text = health.toString()
                    weHaveALoser(health, layout)
                }
                layout.buttons.minus_five.setOnClickListener {
                    var health = layout.playerText.health.text.toString().toInt()
                    health -= 5
                    layout.playerText.health.text = health.toString()
                    weHaveALoser(health, layout)
                }
            }
        }
    }

}
