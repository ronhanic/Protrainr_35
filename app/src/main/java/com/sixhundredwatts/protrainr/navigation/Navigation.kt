package com.sixhundredwatts.protrainr.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN
import com.sixhundredwatts.protrainr.navigation.destinations.listComposable

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController=navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        composable("listScreen") {
            listComposable(navigateToTasksScreen = screen.task)
        }
     // taskComposable(navigateToListScreen = screen.list)
    }

}