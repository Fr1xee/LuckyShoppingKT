package com.example.luckyshopping.vm

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.luckyshopping.pojo.Product
import com.example.luckyshopping.db.ProductDao
import com.example.luckyshopping.db.ProductDatabase

class Repository(application: Application) {

    var product: LiveData<List<Product?>?>?
    var dao: ProductDao? = ProductDatabase.getDatabase(application.applicationContext)!!.productDao()

    fun insertProduct(product: Product?) {
        ProductDatabase.dbWriteExecutor.execute { dao!!.insertProduct(product) }
    }

    fun deleteProduct() {
        dao!!.deleteProduct()
    }

    init {
        product = dao!!.LoadAllProduct()
    }
}