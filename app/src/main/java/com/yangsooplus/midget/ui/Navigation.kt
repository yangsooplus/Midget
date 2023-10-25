package com.yangsooplus.midget.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yangsooplus.feature_custom.CustomScreen
import com.yangsooplus.feature_home.home.HomeScreen
import com.yangsooplus.feature_home.select.SelectScreen

@Composable
fun Navigation(destination: String, appWidgetId: Int?) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = destination) {
        composable("home") { HomeScreen { navController.navigate("custom") } }
        composable("custom") { CustomScreen { navController.navigate("home") } }
        composable("select") {
            appWidgetId?.let {
                SelectScreen(appWidgetId = it) {
                    navController.navigate("custom")
                }
            }
        }
    }
}
