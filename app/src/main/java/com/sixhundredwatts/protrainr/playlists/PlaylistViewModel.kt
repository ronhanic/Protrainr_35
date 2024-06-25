package com.sixhundredwatts.protrainr.playlists


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import retrofit2.Response
import kotlin.coroutines.EmptyCoroutineContext


class PlaylistViewModel(
   // private var repository: PlaylistRepository
) : ViewModel() {

    private val api = RetrofitInstance.api
    private val service = PlaylistService(api)
    private val repository = PlaylistRepository(service)

//    val playlists = liveData<Result<List<Playlist>>> {
//        emitSource(repository.getPlaylists().asLiveData())
//    }
private val _tickFlow = MutableSharedFlow<Unit>(replay = 0)
    val playlists: MutableState < List < Playlist>> = mutableStateOf(emptyList())


  //  val playlists: StateFlow<List<Playlist>> = MutableStateFlow(emptyList())

    fun getPlaylists() {
        viewModelScope.launch {
            try {
                val response = api.fetchAllPlaylists()
                if(response.isNotEmpty()){
                   playlists.value = response
                }
            } catch (e: Exception) {
                val x = e.message
                val y = e.message
                // Handle errors here
            }
        }
    }

}