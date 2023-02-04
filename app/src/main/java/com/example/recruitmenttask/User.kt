package com.example.recruitmenttask

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("username") val username: String,
)