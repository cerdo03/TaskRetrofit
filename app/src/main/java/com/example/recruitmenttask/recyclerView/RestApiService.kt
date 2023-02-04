package com.example.recruitmenttask.recyclerView


import android.util.Log
import com.example.recruitmenttask.User
import com.example.recruitmenttask.UserListRequest
import com.example.recruitmenttask.User_rvlist
import com.example.recruitmenttask.Users_rv
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RestApiService {
    fun getList(userListreq: UserListRequest, onResult: (User_rvlist?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.getList(userListreq).enqueue(
            object : Callback<User_rvlist> {
                override fun onFailure(call: Call<User_rvlist>, t: Throwable) {
                    Log.d("Error",t.message.toString())
                    onResult(null)
                }
                override fun onResponse(call: Call<User_rvlist>, response: Response<User_rvlist>) {
                    val addedUser = response.body()

                    Log.d("choot",response.errorBody().toString())
                    Log.d("choot",response.toString())
                    onResult(addedUser)
                }


            }
        )
    }
}