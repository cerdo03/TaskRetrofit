package com.example.recruitmenttask

import com.google.gson.annotations.SerializedName

data class User_rvlist(
    @SerializedName ("users") val users: List<Users_rv>,
)