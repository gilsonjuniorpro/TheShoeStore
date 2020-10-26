package theshoestore.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository

class AddShoesViewModel(
    private val repository: ShoesRepository
) : ViewModel() {

    fun saveShoes(shoes: Shoes){
        viewModelScope.launch{
            repository.saveShoes(shoes)
        }
    }
}