package theshoestore.ca.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import theshoestore.ca.util.PrefManager

class LoginViewModel(
    context: Context
) : ViewModel() {
    private val _isUserLoggedIn = MutableLiveData<Boolean>()
    val isUserLoggedIn: LiveData<Boolean>
        get() = _isUserLoggedIn

    private val mPrefManager = PrefManager(context)

    init {
        _isUserLoggedIn.value = mPrefManager.isLoggedIn()
    }

    fun setUserLoggedIn() {
        _isUserLoggedIn.value = true
        mPrefManager.setLoggedIn(true)
    }

    fun setUserNotLoggedIn() {
        _isUserLoggedIn.value = false
        mPrefManager.setLoggedIn(false)
    }
}