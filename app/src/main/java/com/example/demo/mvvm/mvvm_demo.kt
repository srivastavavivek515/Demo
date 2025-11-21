package com.example.demo.mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.update

data class Counter(var count:Int = 0)


class CounterViewModel : ViewModel(){
    private val state  = MutableStateFlow(Counter(1))
    val counterState = state
    fun incrementCounter(){
        state.update {
            it.copy(count = it.count+1)
        }
    }

    fun decrementCounter(){
       state.update {
           it.copy(count =  it.count-1)
       }
    }

}