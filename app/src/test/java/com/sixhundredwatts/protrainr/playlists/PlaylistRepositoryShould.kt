package com.sixhundredwatts.protrainr.playlists

import android.util.Log
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.protrainr.utils.BaseUnitTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times

class PlaylistRepositoryShould :BaseUnitTest() {


  private val playlists = mock<List<Playlist>>()
  private val service:PlaylistService = mock()
  private val exception = RuntimeException("Something went wrong")
  @Test
  fun getPlaylistsFromService() = runTest {
      val repository = PlaylistRepository2(service)
      repository.getPlaylists()
     verify(service,times(1)).fetchPlaylists()
  }

    @Test
    fun emitPlaylistsFromService() = runTest {
        val repository = mockSuccessfulCase()
       

        assertEquals(Result.Success(playlists),repository.getPlaylists().first())
    }

    @Test
    fun propagateErrors() = runTest {
        val repository = mockFailureCase()
        assertEquals(Result.Error(exception), repository.getPlaylists().first())
    }

    private suspend fun mockFailureCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            flow {
                emit(Result.Error(exception))
            }
        )
        val repository = PlaylistRepository(service)
        return repository
    }

    private suspend fun mockSuccessfulCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            flow {
                emit(Result.Success(playlists))
            }
        )
        val repository = PlaylistRepository(service)
        return repository
    }

}