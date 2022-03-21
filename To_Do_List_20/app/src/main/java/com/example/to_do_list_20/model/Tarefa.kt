package com.example.to_do_list_20.model

data class Tarefa(
    var nome: String,
    var descricao: String,
    var responsavel: String,
    var data: String,
    var status: Boolean,
    var categoria: String
) {

}
