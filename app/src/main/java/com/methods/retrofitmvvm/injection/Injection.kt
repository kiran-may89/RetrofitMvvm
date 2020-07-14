package com.methods.retrofitmvvm.injection

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.methods.retrofitmvvm.factory.ViewModelFactory
import com.methods.retrofitmvvm.net.ApiServices
import com.methods.retrofitmvvm.net.ServicesConfig
import com.methods.retrofitmvvm.repository.RecipeRepository
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

object   Injection {

    fun getExecutorServices():ExecutorService{
        return Executors.newFixedThreadPool(4)
    }
    fun provideApiService():ApiServices{
        return  ServicesConfig.getInstance()
    }
    fun provideFactory():ViewModelProvider.Factory{
        return ViewModelFactory<RecipeRepository>(RecipeRepository(provideApiService()))
    }
}