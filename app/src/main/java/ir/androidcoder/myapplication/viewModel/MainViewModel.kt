package ir.androidcoder.myapplication.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.androidcoder.domain.model.PostDEntity
import ir.androidcoder.domain.usecase.PostUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postUsecase: PostUsecase) : ViewModel() {

    private val _post = MutableStateFlow<List<PostDEntity>?>(null)
    val post : StateFlow<List<PostDEntity>?> get() = _post

    init {
        viewModelScope.launch {
            postUsecase.catchData()
        }
        getAllPost()
    }

    private fun getAllPost() {
        viewModelScope.launch {
            postUsecase.getAllPost().collect {
                _post.value = it
            }
        }
    }

}