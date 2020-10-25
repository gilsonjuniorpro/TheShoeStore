package theshoestore.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import theshoestore.ca.model.Shoes

class DetailViewModel : ViewModel() {

    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
        get() = _shoes

    fun setShoes(shoes: Shoes) {
        _shoes.value = shoes
    }
}