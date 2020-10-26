package theshoestore.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.repository.ShoesRepository

class AddShoesViewModelFactory(
    private var repository: ShoesRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddShoesViewModel::class.java)){
            return AddShoesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}