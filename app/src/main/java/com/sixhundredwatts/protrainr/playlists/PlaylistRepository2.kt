package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class PlaylistRepository2 @Inject constructor(private val service: PlaylistService) {
    suspend fun getPlaylists(): Flow<Result<List<Playlist>>> = service.fetchPlaylists()
}
