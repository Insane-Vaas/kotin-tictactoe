package com.example.tictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    protected fun buClick(view:View){

        val buSelected:Button = view as Button

        var cellID = 0
        when(buSelected.id){

            R.id.bu1->cellID = 1
            R.id.bu2->cellID = 2
            R.id.bu3->cellID = 3
            R.id.bu4->cellID = 4
            R.id.bu5->cellID = 5
            R.id.bu6->cellID = 6
            R.id.bu7->cellID = 7
            R.id.bu8->cellID = 8
            R.id.bu9->cellID = 9
            R.id.bu10->cellID = 10

        }
        Toast.makeText(this,"ID:"+cellID,Toast.LENGTH_LONG).show()

        PlayGame(cellID,buSelected)

    }

    var player1 = ArrayList<Int>()

    var player2 = ArrayList<Int>()

    var ActivePlayer = 1

    fun PlayGame(cellID:Int,buSelected:Button){

        if(ActivePlayer==1){

            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            //var mediaPlayer: MediaPlayer? = MediaPlayer.create(applicationContext, R.Raw.pop)

            player1.add(cellID)

            ActivePlayer=2


        }

        else{

            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.BLUE)

            player2.add(cellID)

            ActivePlayer = 1


        }


        buSelected.isEnabled = false
        CheckWinner()


    }

    fun CheckWinner() {

        var winner = -1

        //row =1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {

            winner = 1

        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {

            winner = 2

        }

        //row = 2

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {

            winner = 1

        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {

            winner = 2

        }

        //row = 3

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {

            winner = 1

        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {

            winner = 2

        }

        //col 1

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {

            winner = 1

        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {

            winner = 2

        }

        //col = 2

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {

            winner = 1

        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {

            winner = 2

        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {

            winner = 1

        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {

            winner = 2

        }

        //dia = 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {

            winner = 1

        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {

            winner = 2

        }

        //dia = 2

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {

            winner = 1

        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {

            winner = 2

        }

        if (player1.contains(10) || player2.contains(10)){

            recreate()

        }

        //stop taking inputs after winner is declared

        fun stopTime(){

            bu1.isEnabled = false

            bu2.isEnabled = false

            bu3.isEnabled = false

            bu4.isEnabled = false

            bu5.isEnabled = false

            bu6.isEnabled = false

            bu7.isEnabled = false

            bu8.isEnabled = false

            bu9.isEnabled = false

        }



        //WINNER DEC.

        if(winner == 1) {

            stopTime()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Winner Winner")
            builder.setMessage("Player 1 has won the Game")
            builder.setPositiveButton("Restart",{ dialogInterface: DialogInterface, i: Int ->10
                recreate()})
            builder.show()

        }
        else if(winner == 2) {

            stopTime()
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Winner Winner ")
            builder.setMessage("Player 2 has won the game")
            builder.setPositiveButton("Restart",{ dialogInterface: DialogInterface, i: Int ->10
                recreate()})

            builder.show()



        }
        else if(winner == -1){

            Toast.makeText(this, "Enjoy the game ", Toast.LENGTH_LONG).show()

        }
        else{

            Toast.makeText(this, "Happy playing", Toast.LENGTH_LONG).show()
        }





    }


}
