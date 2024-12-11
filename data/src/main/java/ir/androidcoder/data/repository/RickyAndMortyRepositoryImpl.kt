package ir.androidcoder.data.repository

import androidx.paging.Pager
import ir.androidcoder.data.source.RickyAndMortySource
import ir.androidcoder.domain.model.RickyEntity
import ir.androidcoder.domain.repository.RickyRepository
import javax.inject.Inject

class RickyAndMortyRepositoryImpl @Inject constructor(private val rickyAndMortySource: RickyAndMortySource) : RickyRepository {

    override fun getRickyAndMorty(): Pager<Int, RickyEntity> = rickyAndMortySource.getRickyAndMorty()

}