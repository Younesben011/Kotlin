package com.example.chatbot2

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class Options:Fragment(R.layout.fragment_options) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val up:ImageView =requireActivity().findViewById(R.id.up)
        val down:ImageView =requireActivity().findViewById(R.id.down)
        val regenerate:ImageView =requireActivity().findViewById(R.id.reset)

        up.animate().apply {
            duration= 20
            translationYBy(-120f)

        }.withEndAction{
            regenerate.animate().apply {
                duration= 20
                translationYBy(-120f)
            }.withEndAction{
                down.animate().apply {
                    duration= 20
                    translationYBy(-120f)
                }.start()
            }
        }
    }
}