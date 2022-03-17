package com.example.myapplication.retrofit

import retrofit2.Call
import com.example.myapplication.model.Votes
import com.example.myapplication.retrofit.Const.DEMO_API_KEY
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers

interface Service {

 @Headers("x-api-key: $DEMO_API_KEY")
 @GET("votes")
 fun getVotes(@Body v : Votes): Call<List<Votes>>
}