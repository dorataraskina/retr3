package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.myapplication.model.VoteDelete
import com.example.myapplication.model.Votes
import com.example.myapplication.model.VotesPost
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
                //стала вылетать ошибка, когда начала писать для post

                gVotes()
                pVotes()
                dVotes()
            }
        }
    }

    fun gVotes() {
        val service = Inter.api
        service.getVotes().enqueue(object : Callback<List<Votes>> {
            override fun onResponse(call: Call<List<Votes>>, response: Response<List<Votes>>) {
                if (response.body() != null) {
                    Log.d("VOTES", response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<Votes>>, t: Throwable) {
                Log.d("ERROR", "ERROR getVotes")
            }

        })
    }

    private fun pVotes() {
        val service = Inter.api
        service.postVotes(VotesPost("", 1)).enqueue(object : Callback<VotesPost> {
            override fun onResponse(call: Call<VotesPost>, response: Response<VotesPost>) {
                if (response.body() != null) {
                    Log.d("VOTES", response.body()!!.message)
                }
            }

            override fun onFailure(call: Call<VotesPost>, t: Throwable) {
                Log.d("ERROR", "ERROR deleteVotes")
            }

        })
    }

    fun dVotes() {
        val service = Inter.api/*не запускается gVotes*/
        service.deleteVotes("").enqueue(object : Callback<List<VoteDelete>> {
            override fun onResponse(
                call: Call<List<VoteDelete>>,
                response: Response<List<VoteDelete>>
            ) {
                if (response.body() != null) {
                    Log.d("VOTES", response.body().toString())
                }
            }

            override fun onFailure(call: Call<List<VoteDelete>>, t: Throwable) {
                Log.d("ERROR", "ERROR deleteVotes")
            }
        })
    }
}
