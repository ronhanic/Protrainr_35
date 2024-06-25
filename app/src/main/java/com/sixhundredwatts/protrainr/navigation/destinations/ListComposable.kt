package com.sixhundredwatts.protrainr.navigation.destinations


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel

import com.sixhundredwatts.protrainr.util.Constants.LIST_ARGUMENT_KEY
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN
import com.sixhundredwatts.todo.ui.screens.list.ListScreen

fun NavGraphBuilder.listComposable(
    viewModel: PlaylistViewModel,
    navigateToTasksScreen:(taskId:Int) -> Unit
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
                type = NavType.StringType
        })) {
             ListScreen(viewModel,navigateToTasksScreen = navigateToTasksScreen)
       }

}

