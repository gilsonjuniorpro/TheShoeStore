package theshoestore.ca.repository

import android.content.Context
import kotlinx.coroutines.flow.Flow
import theshoestore.ca.model.Shoes

class ShoesRepository(context: Context) {

    private val shoesDao =
        AppDatabase.getDatabase(context).getShoesDao()

    suspend fun saveShoes(shoes: Shoes){
        shoesDao.insertShoes(shoes)
    }

    suspend fun updateShoes(shoes: Shoes){
        shoesDao.updateShoes(shoes)
    }

    suspend fun deleteShoes(shoes: Shoes){
        shoesDao.deleteShoes(shoes)
    }

    fun getAllShoes(): Flow<List<Shoes>> {
        return shoesDao.getAllShoes()
    }

    fun search(id: Int): Shoes {
        return shoesDao.getShoes(id)
    }
}