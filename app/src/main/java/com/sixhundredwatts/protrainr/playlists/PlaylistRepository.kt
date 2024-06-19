package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PlaylistRepository(
    private val service: PlaylistService
) {
    suspend fun getPlaylists(): Flow<Result<List<Playlist>>> =
        service.fetchPlaylists()

}
