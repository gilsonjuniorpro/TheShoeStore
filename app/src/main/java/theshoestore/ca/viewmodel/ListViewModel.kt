package theshoestore.ca.viewmodel

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import theshoestore.ca.model.Shoes
import theshoestore.ca.model.ShoesDto
import theshoestore.ca.repository.ShoesHttp
import theshoestore.ca.repository.ShoesRepository
import theshoestore.ca.util.PrefManager
import theshoestore.ca.util.Util
import java.lang.Exception

class ListViewModel(
    private val repository: ShoesRepository,
    application: Application
) : ViewModel() {
    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
        get() = _shoes

    private val _isPopulated = MutableLiveData<Boolean>()
    val isPopulated: LiveData<Boolean>
        get() = _isPopulated

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    //private val mPrefManager = PrefManager(application)

    fun setPopulated() {
        _isPopulated.value = true
        //mPrefManager.setPopulated(true)
    }

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _isPopulated.postValue(repository.count() > 0)
            }
        }
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
            _state.value = State.Loading

            val list = withContext(Dispatchers.IO) {
                ShoesHttp.fetchData()
            }
            if(list?.items == null){
                _state.value = State.Error(Exception("Error loading books"), false)
            }else{
                _state.value = State.Loaded(list.items)
            }

            //val list = Util.getListOfShoes()
            list?.items?.forEach{ shoes ->
                repository.saveShoes(Util.mapShoesDtoToShoes(shoes))
            }
        }
    }

    sealed class State {
        object Loading: State()
        data class Loaded(val items: List<ShoesDto>): State()
        data class Error(val e: Throwable, var hasConsumed: Boolean): State()
    }
}