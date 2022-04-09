package com.example.trd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_page_link.setOnClickListener {
            val intent = Intent(this@MainActivity, Reg_activity::class.java)
            startActivity(intent)

        }

        login_button.setOnClickListener {
            when {
                TextUtils.isEmpty(userLoginEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Enter Email to log in",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(userLoginPassword.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Enter a Password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val loginemail: String = userLoginEmail.text.toString().trim { it <= ' ' }
                    val loginpassword: String = userLoginPassword.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(loginemail, loginpassword)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {

                                Toast.makeText(
                                    this@MainActivity,
                                    "Login successful.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this@MainActivity, Landing_activity::class.java)

                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_email", loginemail)
                                startActivity(intent)
                                finish()


                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                }

            }


        }


    }

}