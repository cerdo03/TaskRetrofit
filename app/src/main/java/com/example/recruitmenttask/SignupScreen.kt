package com.example.recruitmenttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.recruitmenttask.databinding.ActivitySignupScreenBinding


class SignupScreen : AppCompatActivity() {
    lateinit var binding: ActivitySignupScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupScreenBinding.inflate(layoutInflater)

        binding.txtAlreadyHaveAnAccount.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSignup.setOnClickListener {
            val username = binding.edtxtUsername.text.toString()
            val email = binding.edtxtEmail.text.toString()
            val password = binding.edtxtPassword.text.toString()

            Log.d("land", "Username: $username")
            Log.d("land", "Email: $email")
            Log.d("land", "Password: $password")

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                if(username.isEmpty())
                    binding.edtxtUsername.error = "Please enter your username"
                if(email.isEmpty())
                    binding.edtxtEmail.error = "Please enter your email"
                if(password.isEmpty())
                    binding.edtxtPassword.error = "Please enter your password"
            } else {

                val apiService = RestApiService()
                val userInfo = User(
                    username = username,
                    email = email,
                    password= password)

                apiService.addUser(userInfo) {
                    if (it != null) {
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }
                    else{
                        //make a toast of some error encountered
                        Toast.makeText(this,"Some error encountered, please check length of password, unique id and email etc",Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        setContentView(binding.root)



    }
}