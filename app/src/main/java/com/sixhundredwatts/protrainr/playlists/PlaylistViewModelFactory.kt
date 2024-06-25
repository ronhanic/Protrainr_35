package com.sixhundredwatts.protrainr.playlists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory

class PlaylistViewModelFactory(
    private val repository: PlaylistRepository
) : Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return PlaylistViewModel(repository) as T
//    }

}