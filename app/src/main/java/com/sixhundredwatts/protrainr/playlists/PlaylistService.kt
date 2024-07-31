package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import com.sixhundredwatts.protrainr.playlists.Result
import com.sixhundredwatts.protrainr.playlists.Result.*
import kotlinx.coroutines.flow.FlowCollector

class PlaylistService(
    private val api:PlaylistAPI
) {
    suspend fun fetchPlaylists() : Flow<Result<List<Playlist>>>  {

        return flow {
            emit(Success(api.fetchAllPlaylists()))
        }.catch { e->

            //emit(Error(Exception("Error fetching playlists:"))
            throw RuntimeException("Error fetching playlists:")


        }
    }


}