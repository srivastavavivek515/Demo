package com.example.demo.navigation3.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.demo.navigation3.Routes
import com.example.demo.navigation3.screens.HomeScreen
import com.example.demo.navigation3.screens.ProfileScreen

class TestNavigation3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val backStack = remember { mutableStateListOf<Routes>(Routes.HomeScreen) }
            NavDisplay(backStack = backStack, onBack = {backStack.removeLastOrNull()},
                entryProvider = entryProvider {
                    entry<Routes.HomeScreen> {
                        HomeScreen(move = {it->
                            val student = Student("ankit")
                            backStack.add(Routes.ProfileScreen(student))
                        })
                    }
                    entry<Routes.ProfileScreen> {it->
                        ProfileScreen(backStack,it.data)
                    }
                }
            )
        }
    }
}

data class Student(val name:String)



