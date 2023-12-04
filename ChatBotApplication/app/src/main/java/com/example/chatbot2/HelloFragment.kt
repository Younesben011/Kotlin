package com.example.chatbot2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HelloFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelloFragment : Fragment(R.layout.fragment_hello) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val startBtn = requireActivity().findViewById<Button>(R.id.start)
            val messages_fragment = Messages()
        startBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment,messages_fragment)
                commit()
            }
        }
    }
}
