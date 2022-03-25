package com.example.trd

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController


class landing_fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landing_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val purchase_icon = view.findViewById<TextView>(R.id.purchase_text)
        val buttonMkt = view.findViewById<Button>(R.id.mkt_btn)
        buttonMkt.setOnClickListener{
            activity?.let {
                val intent = Intent(it,mkt_activity::class.java)
                it.startActivity(intent)
            }
        }
        purchase_icon.setOnClickListener{
            activity?.let {
                val intent = Intent(it,mkt_activity::class.java)
                it.startActivity(intent)
            }
        }


    }



}