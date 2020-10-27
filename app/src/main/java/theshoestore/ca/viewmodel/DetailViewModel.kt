package theshoestore.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository

class DetailViewModel(
        private val repository: ShoesRepository
) : ViewModel() {

    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
        get() = _shoes

    fun setShoes(shoes: Shoes) {
        _shoes.value = shoes
    }

    fun saveShoes(shoes: Shoes){
        viewModelScope.launch{
            repository.saveShoes(shoes)
        }
    }
}