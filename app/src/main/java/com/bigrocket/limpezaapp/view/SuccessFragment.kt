package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.model.Schedule
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment(R.layout.fragment_success) {

    private val args: SuccessFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDescSchedule()
        setButtonClicked()
    }

    fun setDescSchedule() {
        textViewDescSuccess.text = concatenate(args.schedule)
    }

    fun concatenate(schedule: Schedule) : String {
        return "" +
                "${schedule.typeService}: " +
                "${schedule.date} - Endereço: " +
                "${schedule.address.logradouro}, " +
                "${schedule.address.number} - " +
                "${schedule.address.district}, " +
                "${schedule.address.city} - " +
                "${schedule.address.state} / " +
                "${schedule.address.country}"
    }

    fun setButtonClicked() {
        buttonOk.setOnClickListener {
            var action = SuccessFragmentDirections.actionSuccessFragmentToListServiceFragment(
                args.schedule
            )
            findNavController().navigate(action)
        }
    }
}