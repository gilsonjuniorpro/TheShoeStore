package theshoestore.ca.viewmodel

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import theshoestore.ca.model.Shoes
import theshoestore.ca.util.Util

class ShoesViewModel : ViewModel() {
    private val _list = MutableLiveData<List<Shoes>>()
    val listShoes: LiveData<List<Shoes>>
        get() = _list

    fun listAllShoes(activity: Activity, idioma: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _list.postValue(Util.getListOfShoes())
            }
        }
    }
}