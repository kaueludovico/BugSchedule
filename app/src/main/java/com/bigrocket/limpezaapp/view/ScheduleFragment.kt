package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.model.Address
import com.bigrocket.limpezaapp.model.Schedule
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val args: ScheduleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTypeServiceWith(args.id)
    }

    fun setTypeServiceWith(id: Int) {
        when (id) {
            1 -> textViewTypeService.text = "Limpeza Leve"
            2 -> textViewTypeService.text = "Limpeza Média"
            3 -> textViewTypeService.text = "Limpeza Pesada"
        }
        setButtonClicked()
    }

    fun setButtonClicked() {
        buttonSchedule.setOnClickListener {
            val schedule = Schedule(
                textViewTypeService.text.toString(),
                editTextDateSchedule.text.toString(),
                Address(
                    editTextAddressSchedule.text.toString(),
                    editTextNumberSchedule.text.toString(),
                    editTextDistrictSchedule.text.toString(),
                    editTextCitySchedule.text.toString(),
                    editTextStateSchedule.text.toString(),
                    editTextCountrySchedule.text.toString()
                )
            )
            var action = ScheduleFragmentDirections.actionScheduleFragmentToSuccessFragment(
                schedule
            )
            findNavController().navigate(action)
        }
    }
}