package ir.androidcoder.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.androidcoder.data.local.entities.PostEntity

@Database(entities = [PostEntity::class] , version = 1 , exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

}