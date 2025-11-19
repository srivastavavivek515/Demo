package com.example.demo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://yourapi.com/"

val apiService: ApiService by lazy {
    Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build().create(
        ApiService::class.java)
}


interface ApiService{
    @GET("test")
   suspend fun getAllData(): List<Todo>

   @GET("test/{id}")
    suspend fun getDataById(@Path("id")id:Int)

    @GET("test")
    suspend fun getDataByIdQ(@Query("id") id:Int)

    @POST("test")
    suspend fun postData(@Body todo: Todo): Todo

    @DELETE("test/{id}")
    suspend fun deleteData(@Path("id")id:Int): Todo
}

data class Todo(val id:Int,val name:String)