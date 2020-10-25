package theshoestore.ca.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.Util

class AddShoesViewModel(
    private val repository: ShoesRepository,
    private val context: Context
) : ViewModel() {

    fun saveShoes(shoes: Shoes){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                repository.saveShoes(shoes)
            }
        }
    }
}