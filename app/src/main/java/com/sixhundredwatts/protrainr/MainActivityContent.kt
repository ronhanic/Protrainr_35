package com.sixhundredwatts.protrainr

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sixhundredwatts.protrainr.playlists.PlaylistRepository
import com.sixhundredwatts.protrainr.playlists.PlaylistService
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel2
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN
import com.sixhundredwatts.todo.ui.screens.list.ListScreen

@Composable
fun MainActivityContent() {


    val navController = rememberNavController()
    NavHost (navController=navController, startDestination = "listscreen" ) {
        composable(route="listscreen") { backstackentry->
            val viewModel = hiltViewModel<PlaylistViewModel2>();
            ListScreen(viewModel)
        }
    }

}