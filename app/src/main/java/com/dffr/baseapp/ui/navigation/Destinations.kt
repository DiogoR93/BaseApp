package com.dffr.baseapp.ui.navigation

sealed class Destinations(val route: String) {
    object Home : Destinations("home")
    object Detail : Destinations("detail/{itemId}") {
        fun createRoute(itemId: String) = "detail/$itemId"
    }
    object Settings : Destinations("settings")
}