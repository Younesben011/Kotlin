package com.example.chatbot2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Messages : Fragment(R.layout.fragment_messages) {
    lateinit var recyclerView:RecyclerView

    fun updateAdapter(messages_data:ArrayList<item>){
        val adapter = MyAdapter(messages_data)
        recyclerView.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val startBtn = requireActivity().findViewById<Button>(R.id.send)
        val message = requireActivity().findViewById<EditText>(R.id.message_text)

        recyclerView =requireActivity().findViewById(R.id.messages_container)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity().baseContext)

        val messages_data = ArrayList<item>()
        updateAdapter(messages_data)

        val optionsFragment = Options()

        startBtn.setOnClickListener {
            println(message.text.toString())
            messages_data.add(item(message.text.toString(),true))
            updateAdapter(messages_data)
            messages_data.add(item(message.text.toString(),false))
            updateAdapter(messages_data)
            message.setText("")
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.options,optionsFragment)
                commit()
            }
        }
    }

}