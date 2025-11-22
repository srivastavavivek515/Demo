package com.example.demo.navigation3.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.demo.navigation3.Routes
import com.example.demo.navigation3.main.Student

@Composable
fun HomeScreen(move:(String)->Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Button(onClick = {
            move("vivek")
        }) {
            Text("Go to Profile screen")
        }
    }
}


@Composable
fun ProfileScreen(backStack: SnapshotStateList<Routes>, data: Student) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

        Button(onClick = {
            backStack.removeLastOrNull()
        }) {
            Text("Back to home ${data.name} ")
        }
    }
}


@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    
}