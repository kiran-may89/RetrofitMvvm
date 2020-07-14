package com.methods.retrofitmvvm.dto

import okhttp3.ResponseBody
import retrofit2.Converter

class ResponseBodyConverter<T>(
    val converter: Converter<ResponseBody,
            ApiResponse<T>>
) : Converter<ResponseBody, T> {

    override fun convert(value: ResponseBody): T? {
        val resonse: ApiResponse<T>? = converter.convert(value)
        resonse?.let {
            if (!it.error!!) {
                return it.data
            }
        }
        throw ApiError(resonse?.statusCode ?: 0, resonse?.message ?: "ERROR")
    }
}