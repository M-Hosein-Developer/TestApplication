package ir.androidcoder.myapplication.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.data.local.PostDao
import ir.androidcoder.data.remote.ApiService
import ir.androidcoder.data.repository.PostRepositoryImpl
import ir.androidcoder.data.source.PostSource

@Module
@InstallIn(SingletonComponent::class)
class PostModule {

    @Provides
    fun provideRepository(postSource: PostSource): PostRepositoryImpl {
        return PostRepositoryImpl(postSource)
    }

    @Provides
    fun provideSource(api: ApiService, dao: PostDao): PostSource {
        return PostSource(api, dao)
    }
}
