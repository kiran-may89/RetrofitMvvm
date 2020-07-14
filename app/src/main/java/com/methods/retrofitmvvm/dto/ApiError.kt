package com.methods.retrofitmvvm.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.RuntimeException

class ApiError(@Expose @SerializedName("statusCode")val statusCOde:Long,@Expose @SerializedName("message")val msg:String ):RuntimeException() {

}