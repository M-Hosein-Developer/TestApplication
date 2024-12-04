package ir.androidcoder.myapplication.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.domain.repository.PostRepository
import ir.androidcoder.domain.usecase.PostUsecase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Provides
    @Singleton
    fun provideUsecase(postRepository: PostRepository) : PostUsecase = PostUsecase(postRepository)

}