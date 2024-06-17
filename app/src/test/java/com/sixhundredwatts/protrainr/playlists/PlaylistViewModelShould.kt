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



    private val repository: PlaylistRepository = mock()
    private val playlist = mock<List<Playlist>>()
    private val expected = Result.success(playlist)
    private val exception = RuntimeException("Something went wrong")
    @Test
    fun getPlaylistsFromRepository() = runTest {
        mockSuccessCase()
        val viewModel = PlaylistViewModel(repository)
       viewModel.playlists.getValueForTest()
       verify(repository,times(1)).getPlaylists()


    }

    @Test
    fun emitErrorWhenReceiveError() {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(Result.failure<List<Playlist>> (exception))
                }
            )
        }
        val viewModel = PlaylistViewModel(repository)
        assertEquals(exception, viewModel.playlists.getValueForTest()!!.exceptionOrNull())
    }
    @Test
    fun emitsPlaylistFromRepository() = runTest{

        mockSuccessCase()
        val viewModel = PlaylistViewModel(repository)
        assertEquals(expected, viewModel.playlists.getValueForTest())
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


    private fun mockFailureCase() {
        runBlocking {

            whenever(repository.getPlaylists()).thenReturn(
                flow {
                    emit(expected)
                }
            )
        }
    }
}