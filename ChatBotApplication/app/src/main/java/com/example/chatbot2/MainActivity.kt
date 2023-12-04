package com.example.chatbot2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hello_fragment = HelloFragment()
        val messages_fragment = Messages()
        val options_fragment = Options()



        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,hello_fragment)
            commit()
        }


    }
}