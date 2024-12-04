package ir.androidcoder.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity(
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
)