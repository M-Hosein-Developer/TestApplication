package ir.androidcoder.domain.repository

import androidx.paging.Pager
import ir.androidcoder.domain.model.PostDEntity
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun catchData()

    fun getPostFromDb() : Flow<List<PostDEntity>>

    suspend fun getPostById(id : Int) : PostDEntity

    fun gerPageByPagePosts() : Pager<Int , PostDEntity>

}