package com.example.recruitmenttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recruitmenttask.recyclerView.RestApiService
import com.example.recruitmenttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<Users_rv> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiService = RestApiService()
        val userLR = UserListRequest(100, 0)

        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter = recyclerViewAdapter(this,list)
        binding.recyclerView.adapter=adapter

        apiService.getList(userLR) {
            if (it != null) {
                list.addAll(it.users)
                adapter.notifyDataSetChanged()
                Log.d("land", "List: $it")

            }

        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutButton -> {
                val sharedPref = PreferenceManager.getDefaultSharedPreferences(
                    applicationContext
                )
                val editor = sharedPref.edit()
                editor.putBoolean("isLoggedIn", false)
                editor.apply()
                editor.commit()

                val intent = Intent(this, SignupScreen::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}