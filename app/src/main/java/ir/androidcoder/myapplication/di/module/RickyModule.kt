package ir.androidcoder.myapplication.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.data.remote.RickyApiService
import ir.androidcoder.data.repository.RickyAndMortyRepositoryImpl
import ir.androidcoder.data.source.RickyAndMortySource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RickyModule {

    @Provides
    fun provideRickySource(apiService: RickyApiService) : RickyAndMortySource = RickyAndMortySource(apiService)


    @Provides
    fun provideRickyRepository(rickyAndMortySource: RickyAndMortySource) : RickyAndMortyRepositoryImpl =
        RickyAndMortyRepositoryImpl(rickyAndMortySource)

}