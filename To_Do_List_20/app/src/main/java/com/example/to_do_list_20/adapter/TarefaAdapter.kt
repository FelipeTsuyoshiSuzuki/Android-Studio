package com.example.to_do_list_20.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list_20.R
import com.example.to_do_list_20.model.Tarefa

class TarefaAdapter: RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {

    private var tarefaLista = emptyList<Tarefa>()

    class TarefaViewHolder (view:View): RecyclerView.ViewHolder(view) {

        val tarefaNome = view.findViewById<TextView>(R.id.tarefaNome)
        val tarefaDescricao = view.findViewById<TextView>(R.id.tarefaDescricao)
        val tarefaResponsavel = view.findViewById<TextView>(R.id.tarefaResponsavel)
        val tarefaData = view.findViewById<TextView>(R.id.tarefaData)
        val tarefaStatus = view.findViewById<Switch>(R.id.tarefaStatus)
        val tarefaCategoria = view.findViewById<TextView>(R.id.tarefaCategoria)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_card, parent, false)

        return TarefaViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = tarefaLista[position]

        holder.tarefaNome.text = tarefa.nome
        holder.tarefaDescricao.text = tarefa.descricao
        holder.tarefaResponsavel.text = tarefa.responsavel
        holder.tarefaData.text = tarefa.data
        holder.tarefaStatus.isChecked = tarefa.status
        holder.tarefaCategoria.text = tarefa.categoria

    }

    override fun getItemCount(): Int {
        return tarefaLista.size
    }

    fun setList(lista: List<Tarefa>) {
        tarefaLista = lista
        notifyDataSetChanged()
    }

}