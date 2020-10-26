package theshoestore.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository

class AddShoesViewModel(
    private val repository: ShoesRepository
) : ViewModel() {

    fun saveShoes(shoes: Shoes){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                repository.saveShoes(shoes)
            }
        }
    }
}