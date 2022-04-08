package com.example.trd

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.*
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import android.widget.Button
import androidx.activity.OnBackPressedDispatcher
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login_fragment.*
import kotlinx.android.synthetic.main.fragment_register_fragment.*
import kotlinx.android.synthetic.main.fragment_register_fragment.userEmail
import kotlinx.android.synthetic.main.fragment_register_fragment.userPassword2


class register_fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        register_button.setOnClickListener {
            when {
                TextUtils.isEmpty(userEmail.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        activity,
                        "Enter Email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(userPassword2.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        activity,
                        "Enter a Password.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email : String = userEmail.text.toString().trim{ it <= ' '}
                    val password : String = userPassword2.text.toString().trim{ it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult>{ task ->
                                if(task.isSuccessful){

                                    val firebaseUser:FirebaseUser = task.result!!.user!!
                                    Toast.makeText(
                                        activity,
                                        "Registration successful.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent =
                                        Intent(activity, mkt_activity::class.java )
                                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        intent.putExtra("user_id", firebaseUser.uid)
                                        intent.putExtra("user_email", email)
                                        startActivity(intent)
                                        this.activity?.finish()


                                }else{
                                    Toast.makeText(
                                        activity,
                                        task.exception!!.message.toString(),
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                            }
                        )

                }

            }

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_fragment, container, false)
    }


}