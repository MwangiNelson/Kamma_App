package com.example.trd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class login_fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     return inflater.inflate(R.layout.fragment_login_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.register_page_link).setOnClickListener {
            view.findNavController().navigate(R.id.action_login_fragment_to_register_fragment)
        }

        view.findViewById<TextView>(R.id.login_button).setOnClickListener {
            view.findNavController().navigate(R.id.action_login_fragment_to_landing_fragment)
        }
    }
}