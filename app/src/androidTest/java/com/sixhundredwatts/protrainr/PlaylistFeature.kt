package com.sixhundredwatts.protrainr

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.todo.ui.screens.list.MyList
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


@RunWith(AndroidJUnit4::class)
class PlaylistFeature {


    @get:Rule val composeTestRule = createComposeRule()

    @Test
    fun displayScreenTitle()  {
        composeTestRule.setContent {
            MainActivityContent()
         }
        runBlocking {
            delay(500)
        }
         composeTestRule.onNodeWithTag("AppBarTitle").assertExists()
        composeTestRule.onNodeWithTag("AppBarTitle").assertTextEquals("List")
    }
    @Test
    fun displayListOfPlaylists() {
        val dataList = listOf(
            Playlist("0","Item 0","cat1",1),
            Playlist("1","Item 1","cat1",2),
            Playlist("2","Item 2","cat1",3),
            Playlist("3","Item 3","cat1",4))



        composeTestRule.setContent {
            val paddingValues = PaddingValues(10.dp)
            val myList = MyList(dataList = dataList, paddingValues,modifier = Modifier.padding(all = 10.dp))
        }

        // Verify each item is displayed
        var count = 0
        dataList.forEach { item ->
            composeTestRule.onNodeWithText(item.name).assertIsDisplayed()
            composeTestRule.onNodeWithText(item.name).assertTextEquals("Item $count")

            count++
        }

        val nodes = composeTestRule.onAllNodesWithTag("playlistitemname")

         // Assert the size of the nodes
        nodes.assertCountEquals(dataList.size)


     }




}
