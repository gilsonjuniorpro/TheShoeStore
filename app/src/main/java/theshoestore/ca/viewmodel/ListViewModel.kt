package theshoestore.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private val _isUserLoggedIn = MutableLiveData<Boolean>()
    val isUserLoggedIn: LiveData<Boolean>
        get() = _isUserLoggedIn

    fun setUserLoggedIn() {
        _isUserLoggedIn.value = true
    }

    fun setUserNotLoggedIn() {
        _isUserLoggedIn.value = false
    }
}