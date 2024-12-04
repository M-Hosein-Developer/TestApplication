package ir.androidcoder.data.repository

import ir.androidcoder.data.mapper.toDomain
import ir.androidcoder.data.source.PostSource
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val postSource: PostSource) : PostRepository {

    override suspend fun catchData() { postSource.catchData() }

    override fun getPostFromDb(): Flow<List<PostDEntity>> = postSource.getPostFromDb()

    override suspend fun getPostById(id: Int): PostDEntity = postSource.getPostById(id).toDomain()


}