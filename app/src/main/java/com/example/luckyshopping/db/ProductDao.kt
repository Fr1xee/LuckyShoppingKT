package com.example.luckyshopping.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.luckyshopping.pojo.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM Product")
    fun LoadAllProduct(): LiveData<List<Product?>?>?

    @Query("DELETE FROM Product")
    fun deleteProduct()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product?)
}