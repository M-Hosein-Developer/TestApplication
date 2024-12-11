package ir.androidcoder.data.pagingSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.androidcoder.data.mapper.toDomain
import ir.androidcoder.data.remote.ApiService
import ir.androidcoder.domain.model.PostDEntity

class PostPagingSource(private val apiService: ApiService) : PagingSource<Int , PostDEntity>() {

    override fun getRefreshKey(state: PagingState<Int, PostDEntity>): Int? = state.anchorPosition?.let { anchor ->
        state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostDEntity> = try {
        val currentPage = params.key ?: 1
        kotlinx.coroutines.delay(1000)
        val response = apiService.getPageByPagePosts(currentPage , 15).map { it -> it.toDomain() }
//        Log.v("testData1" , response.toString())
//        Log.v("testData3" , currentPage.toString())
        LoadResult.Page(
            data = response ,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (response.isEmpty()) null else currentPage + 1
        )
    }catch (e : Exception){
        Log.e("PagingError", "Error loading data: ${e.message}")
        LoadResult.Error(e)
    }

}