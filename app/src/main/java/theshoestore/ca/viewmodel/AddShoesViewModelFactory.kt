package theshoestore.ca.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository
import java.lang.IllegalArgumentException

class AddShoesViewModelFactory(
    private var repository: ShoesRepository,
    private var context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddShoesViewModel::class.java)){
            return AddShoesViewModel(repository, context) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}