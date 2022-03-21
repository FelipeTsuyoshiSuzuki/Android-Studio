package com.example.to_do_list_20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do_list_20.adapter.TarefaAdapter
import com.example.to_do_list_20.model.Tarefa

class RecycleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycle, container, false)


        val lista = listOf<Tarefa>(
            Tarefa(
                "Tarefa1",
                "Iniciar na parte da manhã",
                "eu",
                "2022-21-03",
                true,
                "Dia a Dia"
            ),
            Tarefa(
                "Tarefa 2",
                "Do dia todo",
                "irmão",
                "2022-22-03",
                false,
                "Dia a Dia"
            ),
            Tarefa(
                "ultima tarefa",
                "terminar o dia",
                "eu",
                "2022-26-03",
                false,
                "dia dia"
            )
        )

        val recycler = view.findViewById<RecyclerView>(R.id.tarefaRecycler)

        val adapter = TarefaAdapter()

        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = adapter

        recycler.setHasFixedSize(true)

        adapter.setList(lista)

        return view
    }
}