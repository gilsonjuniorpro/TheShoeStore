package theshoestore.ca.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import theshoestore.ca.repository.ShoesRepository

class ListViewModelFactory(
    private var repository: ShoesRepository,
    private var application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ListViewModel::class.java)){
            return ListViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}