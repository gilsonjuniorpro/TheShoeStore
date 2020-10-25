package theshoestore.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.model.Shoes
import java.lang.IllegalArgumentException

class AddShoesViewModelFactory(private var list: MutableList<Shoes>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddShoesViewModel::class.java)){
            return AddShoesViewModel(list) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}