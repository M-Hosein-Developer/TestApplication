package ir.androidcoder.myapplication.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.domain.repository.PostRepository
import ir.androidcoder.domain.repository.RickyRepository
import ir.androidcoder.domain.usecase.PostUsecase
import ir.androidcoder.domain.usecase.RickyUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Provides
    @Singleton
    fun provideUsecase(postRepository: PostRepository) : PostUsecase = PostUsecase(postRepository)

    @Provides
    @Singleton
    fun provideRickyUsecase(rickyRepository: RickyRepository) : RickyUseCase = RickyUseCase(rickyRepository)

}