package com.generation.todo.api

import com.generation.todo.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("categoria")
    fun listCategoria(): Response<List<Categoria>>
}