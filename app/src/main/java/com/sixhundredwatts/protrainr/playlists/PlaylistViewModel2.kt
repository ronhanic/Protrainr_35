package com.sixhundredwatts.protrainr.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel2 @Inject constructor(
    private val repository: PlaylistRepository2) : ViewModel() {
    private val _playlists = MutableStateFlow<Result<List<Playlist>>>(Result.Success(emptyList()))
    val playlists: StateFlow<Result<List<Playlist>>> = _playlists

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        fetchPlaylists()
    }

    private fun fetchPlaylists() {
        viewModelScope.launch {


            try {
                repository.getPlaylists().collect { result ->
                    _playlists.value = result
                }
            } catch (e: Exception) {

                // Handle the exception, e.g., log it or update the UI state
                //Log.e("fetchPlaylists", "Error fetching playlists", e)
                // You might also want to update a LiveData to notify the UI about the error
                _playlists.value = Result.Error(Exception(e.message))
                //_error.value = e.message
            }

           // repository.getPlaylists().collect { result ->
          //  //    _playlists.value = result
            //}
        }
    }
}