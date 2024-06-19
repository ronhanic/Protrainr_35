package com.sixhundredwatts.protrainr.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sixhundredwatts.protrainr.domain.entities.Playlist
import com.sixhundredwatts.protrainr.playlists.PlaylistRepository
import org.junit.Rule
import org.mockito.kotlin.mock

open class BaseUnitTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()



}