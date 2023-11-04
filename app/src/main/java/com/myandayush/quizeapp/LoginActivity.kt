package com.myandayush.quizeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.myandayush.quizeapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Here we will do simple login and signup work
        binding.signupButton.setOnClickListener {
            Firebase.auth.createUserWithEmailAndPassword(binding.signupEmail.editableText.toString(),
             binding.signupPassword.editableText.toString()).addOnCompleteListener {
                 if (it.isSuccessful){
                     Toast.makeText(this,"User Created !!", Toast.LENGTH_LONG).show();
                 }else{
                     Toast.makeText(this,"User Not Created !!", Toast.LENGTH_LONG).show();
                 }
            }
        }


    }
}