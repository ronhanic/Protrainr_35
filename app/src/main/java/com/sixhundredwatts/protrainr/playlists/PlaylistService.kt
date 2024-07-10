package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import com.sixhundredwatts.protrainr.playlists.Result
class PlaylistService(
    private val api:PlaylistAPI
) {
    suspend fun fetchPlaylists() : Flow<Result<List<Playlist>>>  {

        return flow {
            emit(Result.Success(api.fetchAllPlaylists()))
        }.catch {
          // emit(Result.Error(Exception("Something went wrong")))
        }
    }


}