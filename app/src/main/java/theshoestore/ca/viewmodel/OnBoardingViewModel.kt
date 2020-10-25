package theshoestore.ca.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import theshoestore.ca.util.PrefManager

class OnBoardingViewModel(application: Application) : AndroidViewModel(application) {
    private val _isFirstTime = MutableLiveData<Boolean>()
    val isFirstTime: LiveData<Boolean>
        get() = _isFirstTime

    private val mPrefManager = PrefManager(getApplication())

    fun setNotFirstTime() {
        _isFirstTime.value = false
        mPrefManager.setFirstTimeLaunch(false)
    }

    fun isItTheFirstTime(){
        _isFirstTime.value = mPrefManager.isFirstTimeLaunch()
    }
}