package com.generation.todo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todo.databinding.FragmentFormBinding
import com.generation.todo.databinding.FragmentListBinding
import com.generation.todo.fragment.DatePickerFragment
import com.generation.todo.fragment.TimePickerListener
import com.generation.todo.model.Categoria
import com.generation.todo.repository.Repository
import java.time.LocalDate

class FormFragment : Fragment(), TimePickerListener {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(
            layoutInflater, container, false
        )

        mainViewModel.listCategoria()

        mainViewModel.categoriaResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisicao", response.body().toString())
            popularSpinner(response.body())
        }

        mainViewModel.dataSelecionada.observe(viewLifecycleOwner, {
            selectedDate -> binding.editData.setText(selectedDate.toString())
        })

        binding.buttonSalvar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        binding.editData.setOnClickListener {
            DatePickerFragment(this)
                .show(parentFragmentManager, "DataPicker")
        }

        return binding.root
    }

    fun popularSpinner(categoria: List<Categoria>?) {

        if (categoria != null) {
            binding.spinnerCategoria.adapter = ArrayAdapter(
                requireContext(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                categoria
            )
        }

    }

    override fun onTimeSelected(date: LocalDate) {
        mainViewModel.dataSelecionada.value = date
    }

}