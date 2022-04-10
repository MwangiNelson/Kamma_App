package com.example.trd

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_landing.*

class Landing_activity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val userEmail = intent.getStringExtra("user_email")

        userEmailLanding.text = "$userEmail"

        logout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

        mkt_btn.setOnClickListener{
            startActivity(Intent(this, mkt_activity::class.java ))

        }
    }
}