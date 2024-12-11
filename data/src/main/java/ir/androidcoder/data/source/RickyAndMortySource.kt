package ir.androidcoder.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import ir.androidcoder.data.pagingSource.RickyPagingSource
import ir.androidcoder.data.remote.RickyApiService
import ir.androidcoder.domain.model.RickyEntity
import javax.inject.Inject

class RickyAndMortySource @Inject constructor(private val api: RickyApiService){

    fun getRickyAndMorty() : Pager<Int , RickyEntity> = Pager(
        config = PagingConfig(pageSize = 10 , enablePlaceholders = false),
        pagingSourceFactory = { RickyPagingSource(api) }
    )

}