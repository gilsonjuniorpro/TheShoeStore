package theshoestore.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.model.Shoes

class ListViewModelFactory(private var list: MutableList<Shoes>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListViewModel::class.java)){
            return ListViewModel(list) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}