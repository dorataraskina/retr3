package com.example.myapplication.retrofit

import com.example.myapplication.model.VoteDelete
import retrofit2.Call
import com.example.myapplication.model.Votes
import com.example.myapplication.model.VotesPost
import com.example.myapplication.retrofit.Const.DEMO_API_KEY
import retrofit2.http.*

interface Service {

    @Headers("x-api-key: $DEMO_API_KEY")
    @GET("votes")
    fun getVotes(): Call<List<Votes>>

    /*@Headers("x-api-key: $API_KEY")
    @GET("images/{image_id}")
    fun getImage(
        @Path("image_id") image_id: String,
        @Query("size") size: String
    ): Call<ImageGet>*/
    //это беру как пример и не очень понимаю откудавы взяли image_id и size, почему для size Query используется, а для image_id -> Path

    @Headers("x-api-key: $DEMO_API_KEY")
    @GET("votes/{vote_id}")
    fun getVotesID()

    @Headers("x-api-key: $DEMO_API_KEY")
    @POST("votes")
    fun postVotes(@Body v: VotesPost): Call<VotesPost>

    @Headers("x-api-key: $DEMO_API_KEY")
    @DELETE("votes/{vote_id}")
    fun deleteVotes(@Path("vote_id") vote_id: String): Call<List<VoteDelete>>
}