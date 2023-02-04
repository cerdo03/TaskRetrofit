package com.example.recruitmenttask

import com.google.gson.annotations.SerializedName

class User_login (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)