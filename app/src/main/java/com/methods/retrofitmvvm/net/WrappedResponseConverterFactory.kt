package com.methods.retrofitmvvm.net

import com.methods.retrofitmvvm.dto.ApiResponse
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class WrappedResponseConverterFactory(val create: GsonConverterFactory) : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        val typed:Type  = object :ParameterizedType{
            override fun getRawType(): Type {
             return ApiResponse::class.java
            }

            override fun getOwnerType(): Type? {
                return null;
            }

            override fun getActualTypeArguments(): Array<Type> {
                return  arrayOf(type)
            }
        }
        val converter:Converter<ResponseBody, *> =
            create.responseBodyConverter(typed,annotations,retrofit) as Converter<ResponseBody, *>
        return converter;
    }
}
