package ir.androidcoder.data.pagingSource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.androidcoder.data.mapper.toDomain
import ir.androidcoder.data.remote.RickyApiService
import ir.androidcoder.domain.model.RickyEntity

class RickyPagingSource (private val apiService: RickyApiService) : PagingSource<Int , RickyEntity>() {

    override fun getRefreshKey(state: PagingState<Int, RickyEntity>): Int? = state.anchorPosition?.let { anchor ->
        state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickyEntity> = try{
        val currentPage = params.key ?: 1
        kotlinx.coroutines.delay(1000)
        val response = apiService.getRickyAndMorty(currentPage).results.map { it.toDomain() }
        Log.v("testData1" , response.toString())
        Log.v("testData3" , currentPage.toString())
        LoadResult.Page(
            data = response,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (response.isEmpty()) null else currentPage + 1
        )
    }catch (e : Exception){
        LoadResult.Error(e)
    }

}