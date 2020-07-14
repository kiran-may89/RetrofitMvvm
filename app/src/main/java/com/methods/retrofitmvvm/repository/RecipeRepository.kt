package com.methods.retrofitmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.methods.retrofitmvvm.dto.ReciepResponse
import com.methods.retrofitmvvm.injection.Injection
import com.methods.retrofitmvvm.net.ApiServices

class RecipeRepository(val apiServices: ApiServices) {
    private val reciepeLiveData = MutableLiveData<ReciepResponse>()

    fun getRecipes(): LiveData<ReciepResponse> {
        Injection.getExecutorServices().execute() {
            val call = apiServices.getRecipes("chicken").execute()
            if (call.isSuccessful) {
                reciepeLiveData.postValue(call.body())
            }
        }
        return reciepeLiveData;
    }
}