package com.example.trd

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.navigation.findNavController


class login_fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OnBackPressedDispatcher()


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