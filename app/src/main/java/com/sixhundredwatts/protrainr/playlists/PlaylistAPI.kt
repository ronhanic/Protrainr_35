package com.sixhundredwatts.protrainr.playlists

import com.sixhundredwatts.protrainr.domain.entities.Playlist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET

interface PlaylistAPI

{

    @GET("playlists")
    suspend fun fetchAllPlaylists(): List<Playlist>
    //{
     //  TODO("not implmemented")
//       return  flow {
//           emit(Result.success(api.f))
//       }
   // }


}
