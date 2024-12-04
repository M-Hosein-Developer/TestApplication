package ir.androidcoder.domain.usecase

import ir.androidcoder.domain.repository.PostRepository

class PostUsecase(private val postRepository: PostRepository) {

    suspend fun catchData(){ postRepository.catchData() }

    fun getAllPost() = postRepository.getPostFromDb()

    suspend fun getPostById(id : Int) = postRepository.getPostById(id)

}