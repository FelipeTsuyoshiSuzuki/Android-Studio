package com.generation.todo.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.generation.todo.R
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment(

    private val timePickerListener: TimePickerListener

) : DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_picker, container, false)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendario = Calendar.getInstance()
        calendario.set(Calendar.YEAR, p1)
        calendario.set(Calendar.MONTH, p2)
        calendario.set(Calendar.DAY_OF_MONTH, p3)

        timePickerListener.onTimeSelected(calendario.time.
        toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val ano = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, ano, mes, dia)
    }
}

interface TimePickerListener {

    fun onTimeSelected(date: LocalDate)

}