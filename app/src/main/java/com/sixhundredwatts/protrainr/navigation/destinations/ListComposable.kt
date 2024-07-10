package com.sixhundredwatts.protrainr.navigation.destinations


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel

import com.sixhundredwatts.protrainr.util.Constants.LIST_ARGUMENT_KEY
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN
import com.sixhundredwatts.todo.ui.screens.list.ListScreen

fun NavGraphBuilder.listComposable(
   navController:NavHostController
) {
    composable(
        route = LIST_SCREEN

        ) {





             ListScreen()
       }

}

