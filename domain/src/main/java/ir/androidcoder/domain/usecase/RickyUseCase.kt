package ir.androidcoder.domain.usecase

import androidx.paging.Pager
import ir.androidcoder.domain.model.RickyEntity
import ir.androidcoder.domain.repository.RickyRepository

class RickyUseCase(private val repository: RickyRepository) {

    fun getRickyAndMorty() : Pager<Int , RickyEntity> = repository.getRickyAndMorty()

}