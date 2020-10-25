package theshoestore.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import theshoestore.ca.model.Shoes
import theshoestore.ca.util.Util

class AddShoesViewModel(private var list: MutableList<Shoes>) : ViewModel() {
    private val _listShoes = MutableLiveData<MutableList<Shoes>>()
    val listShoes: LiveData<MutableList<Shoes>>
        get() = _listShoes

    private var _isPopulated : Boolean = false
    val isPopulated: Boolean
        get() = _isPopulated

    private var listOfShoes = mutableListOf<Shoes>()

    init {
        if(isPopulated){
            _listShoes.value = listOfShoes
        }else{
            listOfShoes.addAll(Util.getListOfShoes())
            _listShoes.value = Util.getListOfShoes()
            _isPopulated = true
        }
    }

    fun saveShoes(shoes: Shoes) {
        listOfShoes.add(shoes)
        _listShoes.value = listOfShoes
    }

    fun setList(list: MutableList<Shoes>){
        listOfShoes = list
        _listShoes.value = list
    }
}