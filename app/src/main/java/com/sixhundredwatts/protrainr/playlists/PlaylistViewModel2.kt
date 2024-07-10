package com.sixhundredwatts.protrainr.playlists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel2 @Inject constructor(
    private val repository: PlaylistRepository2) : ViewModel() {
    private val _playlists = MutableStateFlow<Result<List<Playlist>>>(Result.Success(emptyList()))
    val playlists: StateFlow<Result<List<Playlist>>> = _playlists

    init {
        fetchPlaylists()
    }

    private fun fetchPlaylists() {
        viewModelScope.launch {
            repository.getPlaylists().collect { result ->
                _playlists.value = result
            }
        }
    }
}