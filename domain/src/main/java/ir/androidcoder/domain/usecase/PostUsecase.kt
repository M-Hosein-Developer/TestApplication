package ir.androidcoder.domain.usecase

import androidx.paging.Pager
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.domain.repository.PostRepository

class PostUsecase(private val postRepository: PostRepository) {

    suspend fun catchData(){ postRepository.catchData() }

    fun getAllPost() = postRepository.getPostFromDb()

    suspend fun getPostById(id : Int) = postRepository.getPostById(id)

    fun gerPageByPagePosts() : Pager<Int , PostDEntity> = postRepository.gerPageByPagePosts()

}