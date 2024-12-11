package ir.androidcoder.myapplication.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androidcoder.domain.usecase.RickyUseCase
import javax.inject.Inject

@HiltViewModel
class RickyViewModel @Inject constructor(private val useCase: RickyUseCase) : ViewModel() {

    val getRickyAndMorty = useCase.getRickyAndMorty().flow.cachedIn(viewModelScope)

}