package com.example.luckyshopping.db

import android.content.Context
import com.example.luckyshopping.pojo.Product
import androidx.room.Database
import androidx.room.RoomDatabase
import kotlin.jvm.Volatile
import androidx.room.Room
import java.util.concurrent.Executors

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao?

    companion object {
        @Volatile
        private var INSTANCE: ProductDatabase? = null
        private const val NUMBER_OF_THREADS = 4
        val dbWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        fun getDatabase(context: Context): ProductDatabase? {
            if (INSTANCE == null) {
                synchronized(ProductDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            ProductDatabase::class.java, "database"
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}