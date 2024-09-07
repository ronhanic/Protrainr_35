package com.sixhundredwatts.protrainr.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN
//import com.sixhundredwatts.protrainr.navigation.destinations.listComposable
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel2

@Composable
fun SetupNavigation(

    navController: NavHostController
) {
    val screen = remember(navController) {
        Screens(navController=navController)
    }

   /* NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        composable("listScreen") {
            //listComposable(navController)
        }
     // taskComposable(navigateToListScreen = screen.list)
    }*/

}