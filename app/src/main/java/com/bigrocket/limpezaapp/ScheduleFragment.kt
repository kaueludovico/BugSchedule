package com.bigrocket.limpezaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.limpezaapp.model.Address
import com.bigrocket.limpezaapp.model.Schedule
import kotlinx.android.synthetic.main.fragment_schedule.*

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private val args: ScheduleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTypeServiceWith(args.id)
    }

    fun setTypeServiceWith(id: Int){
        when(id) {
            1 -> textViewTypeService.text = "Limpeza Leve"
            2 -> textViewTypeService.text = "Limpeza Média"
            3 -> textViewTypeService.text = "Limpeza Pesada"
        }

        setButtonClicked(textViewTypeService.text.toString())
    }

    fun setButtonClicked(typeService: String) {
        var schedule = Schedule(
            typeService,
            editTextDateSchedule.text.toString(),
            Address(
                editTextAddressSchedule.text.toString(),
                editTextDistrictSchedule.text.toString(),
                editTextNumberSchedule.text.toString(),
                editTextCitySchedule.text.toString(),
                editTextStateSchedule.text.toString(),
                editTextCountrySchedule.text.toString()
            )
        )

        buttonSchedule.setOnClickListener {
            var action = ScheduleFragmentDirections.actionScheduleFragmentToSuccessFragment(
                schedule
            )
            findNavController().navigate(action)
        }
    }
}