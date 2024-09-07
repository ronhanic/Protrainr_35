
package com.sixhundredwatts.protrainr.ui.screens.list


import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.sixhundredwatts.protrainr.ui.theme.toAppBarContentColor
import com.sixhundredwatts.protrainr.R
import kotlin.coroutines.coroutineContext

@Composable
fun ListAppBar() {

    DefaultListAppBar(
        onSearchClicked = {}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
) {
    TopAppBar (
        title = {
            Text(text =  stringResource(id = R.string.list_title),
                modifier = Modifier.testTag("AppBarTitle"),
                color = MaterialTheme.colorScheme.toAppBarContentColor)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked)
        }
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
) {
   SearchAction(onSearchClicked = onSearchClicked)
}


@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
   IconButton(onClick = { onSearchClicked() }) {
       Icon(
           imageVector= Icons.Filled.Search,
           contentDescription = stringResource(id = R.string.search_action),
           tint = MaterialTheme.colorScheme.toAppBarContentColor
           )
   }
}

/*@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit,
) {

}*/

@Preview
@Composable
private fun DefaultListAppBarPreview() {
   DefaultListAppBar(
       onSearchClicked = {}
   )
}