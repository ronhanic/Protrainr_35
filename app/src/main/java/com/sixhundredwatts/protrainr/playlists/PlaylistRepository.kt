package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.Flow

class PlaylistRepository {
    suspend fun getPlaylists(): Flow<Result<List<Playlist>>> {
      TODO("Not yet implemented")
    }
}
