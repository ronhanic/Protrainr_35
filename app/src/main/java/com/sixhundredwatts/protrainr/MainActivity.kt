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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sixhundredwatts.protrainr.navigation.SetupNavigation
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel
import com.sixhundredwatts.protrainr.ui.theme.ProtrainrTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: PlaylistViewModel by viewModels()
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
     //  val engine = Engine(2000,100,15,false)
     //  val car = Car(40.0,engine)

      // car.turnOn()

       super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            ProtrainrTheme {
                Surface( modifier=Modifier.fillMaxSize(),color= MaterialTheme.colorScheme.background) {
                    MainActivityContent(viewModel)
                }

            }
        }
    }
}


