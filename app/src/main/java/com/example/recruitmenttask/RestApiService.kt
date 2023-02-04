package com.example.recruitmenttask

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userData: User, onResult: (User?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    Log.d("Error",t.message.toString())
                    onResult(null)
                }
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    val addedUser = response.body()

                    Log.d("Success",response.errorBody().toString())
                    Log.d("Success",response.toString())
                    onResult(addedUser)
                }
            }
        )
    }
}