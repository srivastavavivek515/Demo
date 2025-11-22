package com.example.demo.flow

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main():Unit = runBlocking {
    /*val collector1 = exampleOfFlow()

    launch {
        collector1.collect {
            println(">>>>>>>>>>>>>First:  $it")
        }
    }
    delay(3000)
    launch {
        collector1.collect {
            println(">>>>>>>>>>>>>Second:  $it")
        }
    }*/

    val collector1 = sharedFlow()

    launch {
        collector1.collect {
            println(">>>>>>>>>>>>>First:  $it")
        }
    }
    delay(3000)
    launch {
        collector1.collect {
            println(">>>>>>>>>>>>>Second:  $it")
        }
    }
}

fun exampleOfFlow(): Flow<Int> {
    return flow {
        repeat(10) {

            emit(it)
            delay(1000)
        }
    }
}

fun sharedFlow() : MutableSharedFlow<Int>{
    val mutableSharedFlow = MutableSharedFlow<Int>()
    GlobalScope.launch {
        repeat(10) {

            mutableSharedFlow.emit(it)
            delay(1000)

        }
    }
    return mutableSharedFlow
}

fun mutableStateFlow() : MutableStateFlow<Int>{
    val mutableStateFlow = MutableStateFlow<Int>(0)
    GlobalScope.launch {
        repeat(10) {

            mutableStateFlow.emit(it)
            delay(1000)

        }
    }
    return mutableStateFlow
}