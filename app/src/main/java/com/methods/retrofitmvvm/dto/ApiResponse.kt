package com.methods.retrofitmvvm.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiResponse<T>( ) {
    @SerializedName("statusCode")
    val statusCode:Long?= null
    @SerializedName("data")
    val data:T?= null
    @SerializedName("error")
    val error: Boolean?= null
    @SerializedName("message")val message:String?= null
}