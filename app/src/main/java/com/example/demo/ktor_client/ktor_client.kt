package com.example.demo.ktor_client

import androidx.compose.animation.core.rememberTransition
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.parameters
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.nio.file.Path

val httpClient =  HttpClient{
    install(ContentNegotiation){
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    install(HttpTimeout){
        socketTimeoutMillis = 3000
        connectTimeoutMillis = 3000
        requestTimeoutMillis = 3000
    }
    install(Logging){
        logger = Logger.ANDROID
    }
}

suspend  fun initGetRequest():List<Post>{
     return httpClient.get("") {
         contentType(ContentType.Application.Json)
    }.body<List<Post>>()
}

suspend  fun initGetRequest(id:Int):Post{
    return httpClient.get("url/${id}") {
        contentType(ContentType.Application.Json)
    }.body<Post>()
}

suspend fun initPost(post: Post): Post{
    return httpClient.post("url") {
        contentType(ContentType.Application.Json)
        setBody(post)
    }.body()
}

suspend fun initGetAgain(id:Int): Path{
    return httpClient.get("test") {
        contentType(ContentType.Application.Json)
        parameter("id",id)
    }.body()
}



@Serializable
data class Post(val name:String, val id:Int)