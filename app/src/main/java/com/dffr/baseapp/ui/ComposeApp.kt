package com.dffr.baseapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dffr.baseapp.ui.home.HomeScreen
import com.dffr.baseapp.ui.navigation.Destinations

@Composable
fun ComposeApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Destinations.Home.route) {
                composable(Destinations.Home.route) { HomeScreen() }
            }
        }
    }
}
