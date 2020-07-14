package com.methods.retrofitmvvm

import com.methods.retrofitmvvm.net.ApiServices
import com.methods.retrofitmvvm.net.ServicesConfig
import org.junit.Test

class SearchApi {

    @Test
    fun searchTest(){
        val api:ApiServices = ServicesConfig.getInstance();
        val response = api.getRecipes("chicken").execute()
        assert(response.isSuccessful)
    }
}