package theshoestore.ca.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import theshoestore.ca.model.Shoes

@Database(entities = [Shoes::class], version = 1, exportSchema = false)
abstract class AppDatabase() : RoomDatabase() {

    abstract fun getShoesDao(): ShoesDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "shoesDb"
                ).build()
            }
            return instance!!
        }
    }
}