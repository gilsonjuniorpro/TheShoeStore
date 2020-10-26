package theshoestore.ca.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.PrefManager
import theshoestore.ca.util.Util

class ListViewModel(
    private val repository: ShoesRepository,
    private val application: Application
) : ViewModel() {
    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
        get() = _shoes

    private val _isPopulated = MutableLiveData<Boolean>()
    val isPopulated: LiveData<Boolean>
        get() = _isPopulated

    private val mPrefManager = PrefManager(application)

    fun setPopulated() {
        _isPopulated.value = true
        mPrefManager.setPopulated(true)
    }

    init {
        _isPopulated.value = mPrefManager.isPopulated()
    }

    val allShoes = repository.getAllShoes().asLiveData()

    fun saveShoes(shoes: Shoes){
        viewModelScope.launch{
            repository.saveShoes(shoes)
        }
    }

    fun updateShoes(shoes: Shoes){
        viewModelScope.launch{
            repository.updateShoes(shoes)
        }
    }

    fun deleteShoes(shoes: Shoes){
        viewModelScope.launch{
            repository.deleteShoes(shoes)
        }
    }

    fun getShoes(id: Int) {
        viewModelScope.launch {
            _shoes.postValue(repository.getShoes(id))
        }
    }

    fun insertListShoes(){
        viewModelScope.launch{
            val list = Util.getListOfShoes()
            list.forEach{ shoes ->
                repository.saveShoes(shoes)
            }
        }
    }
}