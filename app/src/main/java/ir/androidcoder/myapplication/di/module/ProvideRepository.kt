package ir.androidcoder.myapplication.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.data.repository.PostRepositoryImpl
import ir.androidcoder.data.repository.RickyAndMortyRepositoryImpl
import ir.androidcoder.domain.repository.PostRepository
import ir.androidcoder.domain.repository.RickyRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class ProvideRepository {

    @Binds
    abstract fun bindPostRepository(postRepositoryImpl: PostRepositoryImpl): PostRepository

    @Binds
    abstract fun bindRickyRepository(rickyAndMortyImpl: RickyAndMortyRepositoryImpl) : RickyRepository

}