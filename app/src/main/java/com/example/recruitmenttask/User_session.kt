package com.example.recruitmenttask

import com.google.gson.annotations.SerializedName

data class User_session (

    @SerializedName("id") val id: String,
    @SerializedName("created") val created: String,
    @SerializedName("expires") val expires: String,
    @SerializedName("userId") val userId: String,
)