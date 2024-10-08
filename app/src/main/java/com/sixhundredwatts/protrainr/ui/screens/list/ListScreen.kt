package com.sixhundredwatts.todo.ui.screens.list


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.sixhundredwatts.protrainr.ui.screens.list.ListAppBar
import com.sixhundredwatts.protrainr.ui.theme.fabBackgroundColor
import com.sixhundredwatts.protrainr.ui.theme.fabPlusColor
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.HiltViewModelFactory
import com.sixhundredwatts.protrainr.R


import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.protrainr.playlists.PlaylistViewModel2
import com.sixhundredwatts.protrainr.util.Constants

@Composable
fun ListScreen(
   viewModel:PlaylistViewModel2 = hiltViewModel(),
   navController: NavController
) {

   // val viewModel : PlaylistViewModel2 = hiltViewModel<PlaylistViewModel2>()
    val playlistsResult by viewModel.playlists.collectAsState()


    when (playlistsResult) {
        is com.sixhundredwatts.protrainr.playlists.Result.Success -> {
            val playlists = (playlistsResult as com.sixhundredwatts.protrainr.playlists.Result.Success<List<Playlist>>).data

            Scaffold (
                topBar = {
                    ListAppBar()
                },
                floatingActionButton = {
                  ListFab(navController)
                },
                content = { paddingValues->

                    PlaylistList(playlists, paddingValues)

                }

            )

               // floatingActionButton = {
                   // ListFab(navigateToTasksScreen = navigateToTasksScreen)
               // }
     //   }


        }
        is com.sixhundredwatts.protrainr.playlists.Result.Error -> {
            val exception = (playlistsResult as com.sixhundredwatts.protrainr.playlists.Result.Error).exception
            Text("Error: ${exception.message}")
        }
    }
    //val itemList by viewModel.playlists.

    /* Scaffold (
       topBar = {
          ListAppBar()
       },

       content = { paddingValues->

           MyList(
               viewModel = viewModel,
               dataList = playlists,
               paddingValues = paddingValues,

               modifier = Modifier.testTag("listitem")
           )

       },

       floatingActionButton = {
         ListFab(navigateToTasksScreen = navigateToTasksScreen)
       }
   )*/


}

@Composable
fun PlaylistList(playlists: List<Playlist>,paddingValues: PaddingValues) {

    LazyColumn {

        items(playlists) { playlist ->
            PlaylistItem(playlist)
        }
    }
}
@Composable
fun PlaylistItem(playlist: Playlist) {

   Card(
   modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.height(80.dp)
            ) {
            Image(painter = painterResource(
                id = R.drawable.playlist),
                contentDescription ="Playlist Image" )

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = playlist.name,
                    style = TextStyle(color = Color.Black, fontSize = 20.sp),
                            modifier = Modifier.testTag("playlistitemname")
                )
                Text(
                    text = playlist.category,
                    style = TextStyle(color = Color.Black, fontSize = 16.sp),
                    modifier = Modifier.testTag("playlistitemcategory")
                )

            }
        }


    }


}
//@Composable
//fun MyCard(
//    data: Playlist,
//) {
//    Card(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier.height(80.dp)
//            ) {
//            Image(painter = painterResource(
//                id = R.drawable.playlist),
//                contentDescription ="Playlist Image" )
//
//            }
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 20.dp, end = 8.dp),
//                horizontalAlignment = Alignment.Start
//            ) {
//                Text(
//                    text = data.name,
//                    style = TextStyle(color = Color.Black, fontSize = 20.sp),
//                            modifier = Modifier.testTag("playlistitemname")
//                )
//                Text(
//                    text = data.category,
//                    style = TextStyle(color = Color.Black, fontSize = 16.sp),
//                    modifier = Modifier.testTag("playlistitemcategory")
//                )
//
//            }
//        }
//
//
//    }
//}
//
//@Composable
//fun MyList(
//    viewModel: PlaylistViewModel,
//    dataList: List<Playlist>,
//    paddingValues: PaddingValues,
//    modifier:Modifier
//) {
//    LazyColumn(
//        modifier = modifier.padding(paddingValues)
//    ) {
//
//        items(dataList) {data->
//            MyCard(data = data )
//        }
//    }
//    DisposableEffect(Unit) {
//        viewModel.getPlaylists()
//        onDispose {}
//    }
//}
@Composable
fun ListFab(navController: NavController
    //navigateToTasksScreen: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {

            navController.navigate("detailscreen")
           // navigateToTasksScreen(-1)
        },
        containerColor = MaterialTheme.colorScheme.fabPlusColor,
        contentColor = MaterialTheme.colorScheme.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Button",
            tint = Color.Blue)
    }
}
//@Composable
//@Preview
//private fun ListScreenPreview(viewModel: PlaylistViewModel) {
//    ListScreen(viewModel,navigateToTasksScreen = {})
//}
