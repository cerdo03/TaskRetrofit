package com.example.recruitmenttask.recyclerView

import com.example.recruitmenttask.User
import com.example.recruitmenttask.UserListRequest
import com.example.recruitmenttask.User_rvlist
import com.example.recruitmenttask.Users_rv
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
    @POST("v1/user/List")
    fun getList(@Body listRequest: UserListRequest): Call<User_rvlist>
}