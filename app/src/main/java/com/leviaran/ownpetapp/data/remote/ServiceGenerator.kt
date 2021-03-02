package com.leviaran.ownpetapp.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

private const val timeoutRead = 30   //In seconds
private const val contentType = "Content-Type"
private const val contentTypeValue = "application/json"
private const val timeoutConnect = 30   //In seconds
private const val BASE_URL = "https://api.thedogapi.com/"


@Singleton
class ServiceGenerator @Inject constructor() {
    private val okhttpBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
    private val retrofit : Retrofit

    private var headerInterceptor = Interceptor { chain ->
        val origin = chain.request()
        val request = origin.newBuilder()
            .header(contentType, contentTypeValue)
            .method(origin.method, origin.body)
            .build()
        chain.proceed(request = request)
    }

    private val logger : HttpLoggingInterceptor
    get() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return loggingInterceptor
    }

    init {
        okhttpBuilder.apply {
            addInterceptor(headerInterceptor)
            addInterceptor(logger)
            connectTimeout(timeoutConnect.toLong(), TimeUnit.SECONDS)
            readTimeout(timeoutRead.toLong(), TimeUnit.SECONDS)
            val client = okhttpBuilder.build()
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }

    }

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }


}