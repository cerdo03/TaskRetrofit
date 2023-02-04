package com.example.recruitmenttask.Login

import android.service.autofill.UserData
import com.example.recruitmenttask.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers(
        "Authorization: Bearer MzljYWUyN2YtNDQ4NS00ZjRhLTgyMGQtNTcxNmEwYjUwNTJi"
//        ,
//        "Content-Type: application/json"
    )
    @POST("v1/user/Login")
    fun logIn(@Body userData: User_login): Call<User_session>
}