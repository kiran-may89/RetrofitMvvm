package com.methods.retrofitmvvm.net.mocks

import com.google.gson.Gson
import com.methods.retrofitmvvm.App
import com.methods.retrofitmvvm.dto.ContentItems
import com.methods.retrofitmvvm.dto.ReciepResponse
import com.methods.retrofitmvvm.net.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MockImpl: ApiServices {
    val recipeFolder = "RECIPE";
    val apiFolder  = "API";
    val recipeId = "recipe_id.json"
    val recipes = "recipes.json";
    val gson:Gson = Gson()
    override fun getRecipes(query: String): Call<ReciepResponse> {
        return object:
            MockCall<ReciepResponse>(){

            override fun enqueue(callback: Callback<ReciepResponse>) {
                val recipe  = gson.fromJson<ReciepResponse>(MockHelper.readFromAsset(App.app.assets,recipeFolder,recipes),ReciepResponse::class.java)
                callback.onResponse(this, Response.success(recipe))
            }
        }

    }

    override fun getContentItems(): Call<ContentItems> {
        return object: MockCall<ContentItems>(){

            override fun enqueue(callback: Callback<ContentItems>) {

               val contentItems =  gson.fromJson<ContentItems>(MockHelper.readFromAssets(App.app.assets).get(0),ContentItems::class.java)
                callback.onResponse(this,Response.success(contentItems))
            }
        }
    }
}