package com.example.recruitmenttask.Login

import android.util.Log
import com.example.recruitmenttask.ServiceBuilder
import com.example.recruitmenttask.User
import com.example.recruitmenttask.User_login
import com.example.recruitmenttask.User_session
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestApiService {
    fun logIn(userData: User_login, onResult: (User_session?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.logIn(userData).enqueue(
            object : Callback<User_session> {
                override fun onFailure(call: Call<User_session>, t: Throwable) {
                    Log.d("Error",t.message.toString())
                    onResult(null)
                }

                override fun onResponse(call: Call<User_session>, response: Response<User_session>) {
                    val addedUser = response.body()

                    Log.d("Success",response.errorBody().toString())
                    Log.d("Success",response.toString())
                    onResult(addedUser)
                }
            }
        )
    }
}