package com.example.recruitmenttask

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
    @POST("v1/user/Create")
    fun addUser(@Body userData: User): Call<User>
}