package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bigrocket.limpezaapp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButtonClick()
    }

    fun setButtonClick() {
        imageButtonEasy.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToScheduleFragment(
                1
            )
            findNavController().navigate(action)
        }

        imageButtonMedium.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToScheduleFragment(
                2
            )
            findNavController().navigate(action)
        }

        imageButtonHard.setOnClickListener {
            var action = HomeFragmentDirections.actionHomeFragmentToScheduleFragment(
                3
            )
            findNavController().navigate(action)
        }
    }
}