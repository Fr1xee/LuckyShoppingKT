package com.example.luckyshopping.vm

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.luckyshopping.pojo.Product
import androidx.lifecycle.AndroidViewModel

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    var videoCards: LiveData<List<Product?>?>?
    var repository: Repository = Repository(application)

    fun insertProduct(product: Product?) {
        repository.insertProduct(product)
    }

    fun deleteVideoCards() {
        repository.deleteProduct()
    }

    init {
        videoCards = repository.product
    }
}