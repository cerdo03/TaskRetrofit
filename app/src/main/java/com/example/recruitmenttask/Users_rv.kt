package com.example.recruitmenttask

import android.security.identity.AccessControlProfile
import com.google.gson.annotations.SerializedName


data class Users_rv (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("username") val username: String,
    @SerializedName("created") val created: String,
    @SerializedName("updated") val updated: String,
    @SerializedName("verified") val verified: Boolean,
    @SerializedName("id") val id: String,
    @SerializedName("token") val verificationDate: String,
    @SerializedName("profile") val profile: Map<String, Any>
)