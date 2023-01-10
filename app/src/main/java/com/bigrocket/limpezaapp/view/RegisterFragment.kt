package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.model.Address
import com.bigrocket.limpezaapp.model.Login
import com.bigrocket.limpezaapp.model.User
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegisterAction.setOnClickListener {
            createUser()
        }
    }

    fun createUser() {
        val user = User(
            0,
            editTextName.text.toString(),
            editTextBirth.text.toString(),
            editTextRg.text.toString(),
            editTextCpf.text.toString(),
            Address(
                editTextAddress.text.toString(),
                editTextNumber.text.toString(),
                editTextDistrict.text.toString(),
                editTextCity.text.toString(),
                editTextState.text.toString(),
                editTextCountry.text.toString()
            ),
            Login(
                editTextEmailRegister.text.toString(),
                editTextPasswordRegister.text.toString()
            )
        )

        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(
            user
        )
        findNavController().navigate(action)
    }
}