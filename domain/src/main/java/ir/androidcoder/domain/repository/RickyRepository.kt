package ir.androidcoder.domain.repository

import androidx.paging.Pager
import ir.androidcoder.domain.model.RickyEntity

interface RickyRepository {

    fun getRickyAndMorty() : Pager<Int, RickyEntity>

}