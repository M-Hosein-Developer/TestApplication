package ir.androidcoder.data.source

import ir.androidcoder.data.local.PostDao
import ir.androidcoder.data.local.entities.PostEntity
import ir.androidcoder.data.mapper.toDomain
import ir.androidcoder.data.mapper.toEntity
import ir.androidcoder.data.remote.ApiService
import ir.androidcoder.domain.model.PostDEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PostSource @Inject constructor(private val api : ApiService , private val dao: PostDao) {

    suspend fun catchData() { dao.insertPost(api.getPost().map { it.toEntity() }) }

    fun getPostFromDb() : Flow<List<PostDEntity>> = flow {
        dao.getAllPost().collect{ data ->
            emit(data.map { it.toDomain() })
        }
    }

    suspend fun getPostById(id : Int) : PostEntity = dao.getPostById(id)

}