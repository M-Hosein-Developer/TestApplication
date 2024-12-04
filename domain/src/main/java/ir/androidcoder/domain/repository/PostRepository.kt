package ir.androidcoder.domain.repository

import ir.androidcoder.domain.model.PostDEntity
import kotlinx.coroutines.flow.Flow

interface PostRepository {

    suspend fun catchData()

    fun getPostFromDb() : Flow<List<PostDEntity>>

    suspend fun getPostById(id : Int) : PostDEntity


}