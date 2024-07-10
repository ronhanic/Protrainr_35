package com.sixhundredwatts.protrainr

import com.sixhundredwatts.protrainr.playlists.PlaylistAPI
import com.sixhundredwatts.protrainr.playlists.PlaylistRepository
import com.sixhundredwatts.protrainr.playlists.PlaylistService
import com.sixhundredwatts.protrainr.playlists.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
//@InstallIn(ActivityComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providePlaylistService(): PlaylistService {

        return PlaylistService(providePlaylistAPI()) // Implement this with your actual service
    }

    @Provides
    @Singleton
    fun providePlaylistRepository(service: PlaylistService): PlaylistRepository {
        return PlaylistRepository(service)
    }

    @Provides
    @Singleton
    fun providePlaylistAPI():PlaylistAPI {
        return RetrofitInstance.api
    }
}