package com.example.demo.navigation3

import com.example.demo.navigation3.main.Student
import okhttp3.Route

sealed class Routes {
    object HomeScreen:Routes()
    data class ProfileScreen(val data: Student): Routes()
}