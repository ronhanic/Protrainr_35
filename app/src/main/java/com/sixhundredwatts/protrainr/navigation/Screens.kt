package com.sixhundredwatts.protrainr.navigation

import androidx.navigation.NavHostController
import com.sixhundredwatts.protrainr.util.Action
import com.sixhundredwatts.protrainr.util.Constants.LIST_SCREEN


class Screens(navController: NavHostController) {
    val list:(Action) -> Unit = { action->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }
    val task: (Int) -> Unit = {taskId->
        navController.navigate("task/$taskId")
    }

}