package com.generation.todo.model

class Categoria(
    var id: Int,
    var descricao: String,
    var tarefas: List<Tarefa>
){
    override fun toString(): String {
        return descricao!!
    }
}