package com.example.demo.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class CounterState(val counter:Int = 0)

sealed class CounterEvent{
    object CounterIncrement : CounterEvent()
    object CounterDecrement : CounterEvent()
}


class MviModel : ViewModel(){
    private val _counterStateMVI = MutableStateFlow(CounterState())
    val counterStateMVI = _counterStateMVI

    fun onEvent(event: CounterEvent){
        when(event){
            CounterEvent.CounterDecrement -> _counterStateMVI.update {
                it.copy(counter =  it.counter-1)
            }
            CounterEvent.CounterIncrement -> _counterStateMVI.update {
                it.copy(counter =  it.counter+1)
            }
        }
    }

}