package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class TeamFragment(var teamName:String) : Fragment(R.layout.fragment_team) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val team_name:TextView = requireActivity().findViewById(R.id.team_name)
        team_name.setText(teamName)
    }
}