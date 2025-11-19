package com.example.demo.koin_di.module

import com.example.demo.retrofit.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retroModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(get<String>())
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    // ApiService instance
    single<ApiService> {
       // get<Retrofit>().create(ApiService::class.java)
        get<Retrofit>().create(ApiService::class.java)
    }
}