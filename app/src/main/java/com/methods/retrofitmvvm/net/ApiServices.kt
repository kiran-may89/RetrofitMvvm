package com.methods.retrofitmvvm.net


import com.methods.retrofitmvvm.dto.ContentItems
import com.methods.retrofitmvvm.dto.ReciepResponse
import com.methods.retrofitmvvm.dto.Recipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("api/search")
    fun getRecipes(@Query("q")  query:String):retrofit2.Call<ReciepResponse>
    @GET("api/getContentItems")
    fun  getContentItems(): Call<ContentItems>
}