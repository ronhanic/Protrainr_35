package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.protrainr.utils.BaseUnitTest
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import petros.efthymiou.groovy.utils.getValueForTest

class PlaylistViewModelShould : BaseUnitTest() {



    private val repository: PlaylistRepository2 = mock()
    private val playlist = mock<List<Playlist>>()
    private val expected = Result.Success(playlist)
    private val exception = Result.Error(Exception("Something went wrong"))
    @Test
    fun getPlaylistsFromRepository() = runTest {
        mockSuccessCase()
        val viewModel = PlaylistViewModel2(repository)

       verify(repository,times(1)).getPlaylists()


    }

     @Test
    fun emitErrorWhenReceiveError() {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {

                    Result.Error(Exception("x"))
                    //emit(exception)

                }
            )
        }
        val viewModel = PlaylistViewModel2(repository)
        assertEquals(exception, viewModel.playlists.value)
    }



    @Test
    fun emitsPlaylistFromRepository() = runTest{

        mockSuccessCase()
        val viewModel = PlaylistViewModel2(repository)
        assertEquals(expected, viewModel.playlists.value)
    }



    private fun mockSuccessCase() {
        runBlocking {

            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }
    }




}