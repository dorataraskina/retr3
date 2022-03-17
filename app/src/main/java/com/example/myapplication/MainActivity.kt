package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.model.Votes
import com.example.myapplication.retrofit.Inter
import com.example.myapplication.ui.theme.MyApplicationTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                gVotes()
            }
        }
    }

    fun gVotes(){
        val service = Inter.api
        service.getVotes(Votes(426, "c1", "test", 1)).enqueue(object :Callback<List<Votes>>{
            override fun onResponse(call: Call<List<Votes>>, response: Response<List<Votes>>) {
                Log.d("VOTES", response.body()!![1].toString())

            }

            override fun onFailure(call: Call<List<Votes>>, t: Throwable) {
                Log.d("ERROR", "ERROR getVotes")
            }

        })
    }
}
