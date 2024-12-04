package ir.androidcoder.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.androidcoder.data.local.MyDatabase
import ir.androidcoder.data.local.PostDao
import ir.androidcoder.data.remote.ApiService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : MyDatabase = Room.databaseBuilder(
        context,
        MyDatabase::class.java,
        "myDb.db"
    ).build()

    @Provides
    @Singleton
    fun provideDao(db :  MyDatabase) : PostDao = db.postDao()

}