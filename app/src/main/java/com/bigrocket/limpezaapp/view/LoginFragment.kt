package com.bigrocket.limpezaapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.limpezaapp.R
import com.bigrocket.limpezaapp.model.User
import com.bigrocket.limpezaapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val args: LoginFragmentArgs by navArgs()
    private lateinit var viewModel: LoginViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            LoginViewModel.LoginViewModelProvider(
                this))[LoginViewModel::class.java]

        setButtonClick()
    }

    fun setButtonClick() {
        buttonLogin.setOnClickListener {
            args.user?.let { it1 -> callValidateLogin(it1) }
        }

        buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    fun callValidateLogin(user: User) {
        viewModel.validateLogin(user) {
            if (it) {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Erro ao validar login! Verifique seus dados e tente novamente.",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}