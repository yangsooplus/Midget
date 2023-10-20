package com.yangsooplus.midget.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yangsooplus.feature_custom.CustomScreen
import com.yangsooplus.feature_home.HomeScreen

@Composable
fun Navigation(destination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = destination) {
        composable("home") { HomeScreen() { navController.navigate("custom")} }
        composable("custom") { CustomScreen() }
    }
}
