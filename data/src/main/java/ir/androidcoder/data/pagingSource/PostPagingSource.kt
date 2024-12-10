package ir.androidcoder.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.androidcoder.data.model.PostResponse
import ir.androidcoder.data.remote.ApiService
import javax.inject.Inject

class PostPagingSource @Inject constructor(private val apiService: ApiService) : PagingSource<Int , PostResponse>() {

    override fun getRefreshKey(state: PagingState<Int, PostResponse>): Int? = state.anchorPosition?.let { anchor ->
        state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostResponse> = try {
        val currentPage = params.key ?: 1
        val response = apiService.getPageByPagePosts(currentPage , params.loadSize)
        LoadResult.Page(
            data = response ,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (response.isEmpty()) null else currentPage + 1
        )
    }catch (e : Exception){
        LoadResult.Error(e)
    }

}