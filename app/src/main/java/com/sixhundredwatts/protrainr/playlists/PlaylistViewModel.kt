package com.sixhundredwatts.protrainr.playlists


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.sixhundredwatts.protrainr.domain.entities.Playlist


class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = liveData<Result<List<Playlist>>> {
        emitSource(repository.getPlaylists().asLiveData())
    }

}