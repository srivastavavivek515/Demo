package com.example.demo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.demo.mvi.CounterEvent
import com.example.demo.mvi.MviModel
import com.example.demo.mvvm.CounterViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MVVMMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCounter()
        }
    }
}

@Composable
fun ShowCounter(modifier: Modifier = Modifier.fillMaxSize()) {
 /*   val counterViewModel: CounterViewModel = viewModel()
    val counterState by counterViewModel.counterState.collectAsState()*/

    val counterViewModel: MviModel = viewModel()
    val counterState by counterViewModel.counterStateMVI.collectAsState()
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "${counterState.counter}")
        Spacer(modifier = Modifier.height(20.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
             //   counterViewModel.incrementCounter()
                counterViewModel.onEvent(CounterEvent.CounterIncrement)
            }) {
                Text("Increase")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = {
               // counterViewModel.decrementCounter()
                counterViewModel.onEvent(CounterEvent.CounterDecrement)
            }) {
                Text("Decrease")
            }
        }
    }
}