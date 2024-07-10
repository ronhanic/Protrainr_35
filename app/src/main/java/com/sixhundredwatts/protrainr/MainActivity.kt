package com.sixhundredwatts.protrainr


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel2
import com.sixhundredwatts.protrainr.ui.theme.ProtrainrTheme
import com.sixhundredwatts.todo.ui.screens.list.ListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
     //  val engine = Engine(2000,100,15,false)
     //  val car = Car(40.0,engine)

      // car.turnOn()


       super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {


            ProtrainrTheme {
                App()

            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost (navController=navController, startDestination = "listscreen" ) {
        composable(route="listscreen") { backstackentry->
            val viewModel = hiltViewModel<PlaylistViewModel2>();
            ListScreen(viewModel)
        }
    }
}


