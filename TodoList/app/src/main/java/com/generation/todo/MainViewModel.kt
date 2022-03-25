package com.generation.todo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todo.model.Categoria
import com.generation.todo.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    val repository: Repository
): ViewModel() {

    private var _categoriaResponse = MutableLiveData<Response<List<Categoria>>>()

    val categoriaResponse: LiveData<Response<List<Categoria>>> = _categoriaResponse

    fun listCategoria() {
        viewModelScope.launch {

            try {
                val response = repository.listCategoria()
                _categoriaResponse.value = response
            }catch (e: Exception) {
                Log.d("ERRO", e.message.toString())
            }

        }
    }

}