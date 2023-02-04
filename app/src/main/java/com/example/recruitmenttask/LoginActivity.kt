package com.example.recruitmenttask

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recruitmenttask.Login.RestApiService
import com.example.recruitmenttask.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        binding.txtDontHaveAnAccount.setOnClickListener(){
            val intent = Intent(this, SignupScreen::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSignin.setOnClickListener {
            val email = binding.edtxtEmail.text.toString()
            val password = binding.edtxtPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                binding.edtxtEmail.error = "Please enter your email"
                binding.edtxtPassword.error = "Please enter your password"
            } else {

                val apiService = RestApiService()
                val userInfo = User_login(
                    email = email,
                    password= password)

                apiService.logIn(userInfo) {
                    if (it != null) {
                        //store id and password in shared preferences
//                        Log.d("Success",it.expires.toString())
//                        Log.d("Success",it.id)
//                        Log.d("Success",it.userId)
//                        Log.d("Success",it.created)
                        val sharedPref = getDefaultSharedPreferences(
                            applicationContext
                        )
                        val editor = sharedPref.edit()
                        editor.putBoolean("isLoggedIn", true)
                        editor.apply()
                        editor.commit()

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "Some error encountered", Toast.LENGTH_SHORT).show()
                    }
                }

//                val intent = Intent(this, SplashActivity::class.java)
//                startActivity(intent)
//                finish()
            }
        }
        setContentView(binding.root)


    }
}