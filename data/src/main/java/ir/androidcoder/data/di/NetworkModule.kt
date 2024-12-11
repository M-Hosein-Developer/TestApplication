package ir.androidcoder.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.data.remote.ApiService
import ir.androidcoder.data.remote.RickyApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_JSON_URL = "https://jsonplaceholder.typicode.com/"
    private const val BASE_RICKY_URL = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    @Named("json")
    fun provideRetrofit() : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_JSON_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiService(@Named("json") retrofit: Retrofit) : ApiService = retrofit.create(ApiService::class.java)

    //==============================================================================================

    @Provides
    @Singleton
    @Named("richy")
    fun provideRickyRetrofit() : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_RICKY_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideRickyApiService(@Named("richy") retrofit: Retrofit) : RickyApiService = retrofit.create(RickyApiService::class.java)
}