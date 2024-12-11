package ir.androidcoder.data.mapper

import ir.androidcoder.data.model.RickyAndMortyResponse
import ir.androidcoder.domain.model.RickyEntity

fun RickyAndMortyResponse.Result.toDomain(): RickyEntity = RickyEntity(
    created = this.created,
    episode = this.episode,
    gender = this.gender,
    id = this.id,
    image = this.image,
    location = RickyEntity.Location(
        name = this.location.name,
        url = this.location.url
    ),
    name = this.name,
    origin = RickyEntity.Origin(
        name = this.origin.name,
        url = this.origin.url
    ),
    species = this.species,
    status = this.status,
    type = this.type,
    url = this.url
)