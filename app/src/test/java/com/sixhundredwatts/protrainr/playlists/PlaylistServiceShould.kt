package com.sixhundredwatts.protrainr.playlists

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.protrainr.utils.BaseUnitTest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.times

class PlaylistServiceShould:BaseUnitTest() {
    private val playlists:List<Playlist> = mock()


    private lateinit var service: PlaylistService

    val repository:PlaylistRepository2 = mock()
    private val api:PlaylistAPI = mock()
    @Test
    fun fetchPlaylistsFromAPI() = runTest {
        service= PlaylistService(api)
        service.fetchPlaylists().first()

        verify(api,times(1)).fetchAllPlaylists()


    }
    @Test
    fun convertValuesToFlowResultAndEmitThem() = runTest {

        val api:PlaylistAPI = mock()

        whenever(api.fetchAllPlaylists()).thenReturn(playlists)

        val service:PlaylistService = PlaylistService(api)


        assertEquals(Result.Success(playlists),service.fetchPlaylists().first())



    }

    @Test
    fun emitsErrorResultWhenNetworkFails() = runTest {
        whenever(api.fetchAllPlaylists()).thenThrow(RuntimeException("Damn backend Developers"))
        service = PlaylistService(api)

        var result: Result<List<Playlist>>
        try {
            result = service.fetchPlaylists().first()
        }catch(e:Exception) {

            assertEquals("Error fetching playlists:", e.message)
        }
    }

}