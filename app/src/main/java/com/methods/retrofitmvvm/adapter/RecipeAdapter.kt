package com.methods.retrofitmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.methods.retrofitmvvm.BR
import com.methods.retrofitmvvm.R
import com.methods.retrofitmvvm.databinding.RecipeItemBinding
import com.methods.retrofitmvvm.dto.Recipe


class RecipeAdapter() : RecyclerView.Adapter<RecipeAdapter.RecipeItem>() {

    var data: List<Recipe>? = null
        set(value) {

            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItem {
        val inflater = LayoutInflater.from(parent.context)
        val bindingView = DataBindingUtil.inflate<RecipeItemBinding>(
            inflater,
            R.layout.recipe_item,
            parent,
            false
        )
        return RecipeItem(bindingView)

    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecipeItem, position: Int) {
        data?.let {
            holder.bind(it.get(position))
        }

    }

    class RecipeItem(val itemview: RecipeItemBinding) : RecyclerView.ViewHolder(itemview.root) {


        fun bind(item: Recipe) {
            itemview.setVariable(BR.item, item)



        }

        companion object {
            @BindingAdapter("loadImage")
            @JvmStatic
            fun loadImage(view: ImageView, url: String) {
                val requestOptions: RequestOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                Glide.with(view.context)
                    .setDefaultRequestOptions(requestOptions)
                    .load(url)
                    .into(view)

            }
        }


    }
}