package ir.androidcoder.data.mapper

import ir.androidcoder.data.local.entities.PostEntity
import ir.androidcoder.data.model.PostResponse
import ir.androidcoder.domain.model.PostDEntity


fun PostResponse.toEntity() : PostEntity = PostEntity(
    id = id,
    body = body,
    title = title
)

fun PostEntity.toDomain() : PostDEntity = PostDEntity(
    id = id,
    body = body,
    title = title
)