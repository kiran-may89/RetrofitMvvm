package com.methods.retrofitmvvm.viewmodels

import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.methods.retrofitmvvm.adapter.RecipeAdapter
import com.methods.retrofitmvvm.dto.ApiResponse
import com.methods.retrofitmvvm.dto.ReciepResponse
import com.methods.retrofitmvvm.repository.RecipeRepository

class RecipeViewModel(private val repos: RecipeRepository) : ViewModel() {

     val adapter: RecipeAdapter by lazy {
        RecipeAdapter()
    }

    fun getRecipes(): LiveData<ReciepResponse> {
        return repos.getRecipes()
    }

    companion object {
        @BindingAdapter("setAdapter")
        @JvmStatic
        fun setRecyclerAdapter( recyclerView: RecyclerView,adapter: RecipeAdapter) {
            recyclerView.adapter = adapter
        }

}



}