package com.sixhundredwatts.protrainr

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sixhundredwatts.todo.ui.screens.list.ListScreen

@Composable
fun MainActivityContent() {
    val navController = rememberNavController()
    NavHost(navController, startDestination="listScreen") {
        composable("listScreen") {
            ListScreen(navigateToTasksScreen = {})
        }
    }
}