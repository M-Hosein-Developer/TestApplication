package ir.androidcoder.data.remote

import ir.androidcoder.data.model.PostResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("posts")
    suspend fun getPost() : List<PostResponse>

    //paging
    @GET("posts")
    suspend fun getPageByPagePosts(
        @Query("_page") page: Int,
        @Query("_limit") size: Int
    ) : List<PostResponse>

}