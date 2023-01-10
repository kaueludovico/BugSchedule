package com.bigrocket.limpezaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bigrocket.limpezaapp.model.Schedule
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment(R.layout.fragment_success) {

    private val args: SuccessFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDescSchedule()
        println("<<<<<<<<<<<<<")
        println(args.schedule)
        println("<<<<<<<<<<<<<")
    }

    fun setDescSchedule() {
        textViewDescSuccess.text = concatenate(args.schedule)
    }

    fun concatenate(schedule: Schedule) : String {
        var concatenated = "${schedule.typeService}: ${schedule.date} - ${schedule.address}"
        return concatenated
    }
}