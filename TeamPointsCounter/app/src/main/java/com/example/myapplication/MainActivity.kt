package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var score1:TextView
    lateinit var score2:TextView
     var score1Value:Int =0
     var score2Value:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //reset btn
            val reset:Button = findViewById(R.id.reset)
            reset.setOnClickListener {
                score1Value=0
                score2Value=0
                score1.setText(""+score1Value)
                score2.setText(""+score2Value)
            }

        //team1 init
            score1 = findViewById(R.id.score1)
            val team1P3:Button = findViewById(R.id.team1_points3)
            val team1P2:Button = findViewById(R.id.team1_points2)
            val team1P1:Button = findViewById(R.id.team1_points1)

        //team2 init
            score2 = findViewById(R.id.score2)
            val team2P3:Button = findViewById(R.id.team2_points3)
            val team2P2:Button = findViewById(R.id.team2_points2)
            val team2P1:Button = findViewById(R.id.team2_points1)


        //team1 score handlers
        team1P3.setOnClickListener {
            scoreUpdate(1,3)
        }
        team1P2.setOnClickListener {
            scoreUpdate(1,2)

        }
        team1P1.setOnClickListener {
            scoreUpdate(1,1)

        }


        //team2 score handlers
        team2P3.setOnClickListener {
            scoreUpdate(2,3)
        }
        team2P2.setOnClickListener {
            scoreUpdate(2,2)

        }
        team2P1.setOnClickListener {
            scoreUpdate(2,1)

        }
    }

    fun scoreUpdate(team:Int,num:Int){

        if(team==1){
            score1Value+=num
            score1.text=score1Value.toString()
//            score1.setText(score1Value)
        }else{
            score2Value+=num
            score2.text=score2Value.toString()
//            score2.setText(score2Value)
        }
    }
}