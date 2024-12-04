package ir.androidcoder.data.remote

import ir.androidcoder.data.model.PostResponse
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPost() : List<PostResponse>

}