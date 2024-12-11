package ir.androidcoder.data.remote

import ir.androidcoder.data.model.RickyAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickyApiService {

    @GET("character")
    suspend fun getRickyAndMorty(
        @Query("page") page : Int
    ) : RickyAndMortyResponse

}