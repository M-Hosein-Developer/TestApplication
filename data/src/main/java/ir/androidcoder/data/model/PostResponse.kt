package ir.androidcoder.data.model

data class PostResponse(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)