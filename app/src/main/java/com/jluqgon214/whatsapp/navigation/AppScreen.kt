package com.example.navigation.Navigation

sealed class AppScreen(val route: String) {
    object MainScreen: AppScreen("MainScreen")
    object ChatScreen: AppScreen("ChatScreen")
}