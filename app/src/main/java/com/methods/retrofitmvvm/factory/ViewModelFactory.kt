package com.methods.retrofitmvvm.factory

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.methods.retrofitmvvm.repository.RecipeRepository
import com.methods.retrofitmvvm.viewmodels.RecipeViewModel
import java.lang.Exception

class ViewModelFactory<K:Any>(val repos:K):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeViewModel::class.java)){
            return RecipeViewModel(repos as RecipeRepository) as T
        }

        throw  IllegalArgumentException("Unknown ViewModel class")


    }
}