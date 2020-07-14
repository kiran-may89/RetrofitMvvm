package com.methods.retrofitmvvm.net

import com.google.gson.GsonBuilder
import com.methods.retrofitmvvm.BuildConfig
import com.methods.retrofitmvvm.net.mocks.MockImpl

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

public class ServicesConfig {

    companion object {
        var config: ApiServices? =null
        public fun getInstance(): ApiServices =
            config ?: synchronized(this) {
                createService().also {
                    config = it;


                }
            }
        private fun createService(): ApiServices {
            val list:List<Int> = listOf(1,2,3)

            val logginInterceptor = HttpLoggingInterceptor()
            logginInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC)
            logginInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .connectTimeout(1000*60*60,TimeUnit.MILLISECONDS)
                .readTimeout(1000*60*60,TimeUnit.MILLISECONDS)
                .addInterceptor(logginInterceptor).build()


            val builder = GsonBuilder()

            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)

                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .addConverterFactory(WrappedResponseConverterFactory(GsonConverterFactory.create()))
                .build()
            if(BuildConfig.FLAVOR.contains("dev")){
                return MockImpl()
            }
            return retrofit.create(ApiServices::class.java)


        }

    }

}
