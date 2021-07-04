package theshoestore.ca.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import theshoestore.ca.model.Shoes
import theshoestore.ca.repository.ShoesRepository

private const val ACTION_UPDATE = "update"
private const val ACTION_CREATE = "create"
private const val ACTION_DELETE = "delete"

class DetailViewModel(
    private val repository: ShoesRepository
) : ViewModel() {

    enum class Action(val action: String) {
        UPDATE(ACTION_UPDATE),
        CREATE(ACTION_CREATE),
        DELETE(ACTION_DELETE)
    }

    private val _shoes = MutableLiveData<Shoes>()
    val shoes: LiveData<Shoes>
        get() = _shoes

    private val _isEditing = MutableLiveData<Boolean>()
    val isEditing: LiveData<Boolean>
        get() = _isEditing

    private val _isInserting = MutableLiveData<Boolean>()
    val isInserting: LiveData<Boolean>
        get() = _isInserting

    private val _action = MutableLiveData<Action>()
    val action: LiveData<Action>
        get() = _action

    var pictureUri: String? = ""

    fun setActionCreate() {
        _action.value = Action.CREATE
    }

    fun setActionUpdate() {
        _action.value = Action.UPDATE
    }

    fun setActionDelete() {
        _action.value = Action.DELETE
    }

    fun setEditEnabled() {
        _isEditing.value = true
    }

    fun setEditDisabled() {
        _isEditing.value = false
    }

    fun setInsertingEnabled() {
        _isInserting.value = true
        _isEditing.value = true
    }

    fun setInsertingDisabled() {
        _isInserting.value = false
    }

    fun setShoes(shoes: Shoes) {
        _shoes.value = shoes
        pictureUri = if(shoes.pictureUri.isNullOrEmpty()) null else shoes.pictureUri
    }

    fun saveShoes(
        shoesName: String?,
        shoesPrice: String?,
        shoesDescription: String?,
        imagePath: String?,
        pictureUri: String?
    ) {
        val shoes =
            setShoesProperties(shoesName, shoesPrice, shoesDescription, imagePath, pictureUri)

        viewModelScope.launch {
            if (action.value == Action.CREATE) {
                shoes?.let { repository.saveShoes(it) }
            } else {
                shoes?.let { repository.updateShoes(it) }
            }
        }
    }

    private fun setShoesProperties(
        shoesName: String?, shoesPrice: String?, shoesDescription: String?,
        imagePath: String?, pictureUri: String?
    ): Shoes? {
        var id = if (action.value == Action.CREATE) {
            0
        } else {
            shoes.value?.id
        }

        return id?.let {
            Shoes(
                it,
                shoesName,
                shoesDescription,
                shoesPrice,
                imagePath,
                pictureUri
            )
        }
    }
}