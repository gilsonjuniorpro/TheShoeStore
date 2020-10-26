package theshoestore.ca.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.repository.ShoesRepository

class LoginViewModelFactory(
    private var context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(context) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}