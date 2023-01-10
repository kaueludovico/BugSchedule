package com.bigrocket.limpezaapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bigrocket.limpezaapp.model.User
import com.bigrocket.limpezaapp.view.LoginFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginViewModel(val fragment: LoginFragment): ViewModel() {

    fun validateLogin(user: User, callback: (result: (Boolean)) -> Unit) {
        if (user.login.email != fragment.editTextEmail.text.toString() ||
                user.login.senha != fragment.editTextSenha.text.toString()) {
            callback.invoke(false)
        } else {
            callback.invoke(true)
        }
    }

    class LoginViewModelProvider(
        val fragment: LoginFragment
        ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(fragment) as T
        }
    }
}