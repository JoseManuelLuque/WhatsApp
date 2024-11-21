package com.example.navigation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jluqgon214.whatsapp.data.WhatsAppViewModel
import com.jluqgon214.whatsapp.screens.ChatScreen
import com.jluqgon214.whatsapp.screens.MainScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    val viewModel = WhatsAppViewModel()
    
    NavHost(navController = navController, startDestination = AppScreen.MainScreen.route) {
        composable(AppScreen.MainScreen.route) {
            MainScreen(navController, viewModel)
        }
        composable(AppScreen.ChatScreen.route) {
            ChatScreen(navController, viewModel)
        }
    }
}