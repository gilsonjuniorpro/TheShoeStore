package theshoestore.ca.repository

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import theshoestore.ca.model.Shoes

@Dao
interface ShoesDao {
    @Query("SELECT * FROM shoes ORDER BY id DESC")
    fun getAllShoes(): Flow<List<Shoes>>

    @Query("SELECT * FROM shoes WHERE id = :id")
    fun getShoes(id: Int): Shoes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoes(shoes: Shoes)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateShoes(shoes: Shoes)

    @Delete
    suspend fun deleteShoes(vararg note: Shoes)

    @Query("SELECT COUNT(*) FROM shoes")
    fun count(): Int
}