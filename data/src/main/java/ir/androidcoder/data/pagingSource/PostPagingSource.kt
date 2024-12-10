package ir.androidcoder.data.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import ir.androidcoder.data.mapper.toDomain
import ir.androidcoder.data.mapper.toEntity
import ir.androidcoder.data.model.PostResponse
import ir.androidcoder.data.remote.ApiService
import ir.androidcoder.domain.model.PostDEntity
import javax.inject.Inject

class PostPagingSource(private val apiService: ApiService) : PagingSource<Int , PostDEntity>() {

    override fun getRefreshKey(state: PagingState<Int, PostDEntity>): Int? = state.anchorPosition?.let { anchor ->
        state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostDEntity> = try {
        val currentPage = params.key ?: 1
        val response = apiService.getPageByPagePosts(currentPage , params.loadSize).map { it -> it.toDomain() }
        LoadResult.Page(
            data = response ,
            prevKey = if (currentPage == 1) null else currentPage - 1,
            nextKey = if (response.isEmpty()) null else currentPage + 1
        )
    }catch (e : Exception){
        LoadResult.Error(e)
    }

}