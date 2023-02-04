package com.example.recruitmenttask

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()
//    var token="NjljNDc5YTctZmVjOC00NTk3LTk4ODUtYzczYjE5OGU5MWRh"
//    var client = OkHttpClient.Builder().addInterceptor(object : Interceptor {
//        @Throws(IOException::class)
//        override fun intercept(chain: Interceptor.Chain): Response? {
//            val newRequest: Request = chain.request().newBuilder()
//                .addHeader("Authorization", " Bearer $token")
//                .build()
//            return chain.proceed(newRequest)
//        }
//    }).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.m3o.com/") // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}