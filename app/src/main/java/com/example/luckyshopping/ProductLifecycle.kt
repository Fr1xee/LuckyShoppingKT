package com.example.luckyshopping

import androidx.lifecycle.*
import com.example.luckyshopping.activity.ProductActivity
import com.example.luckyshopping.activity.ProductActivity.Companion.productViewModel
import com.example.luckyshopping.pojo.Product

class ProductLifecycle : LifecycleOwner, LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun initViewModel() {
        productViewModel!!.videoCards!!.observe(this, { productVideoCards ->
                if (ProductActivity.count == productVideoCards!!.size) {
                    ProductActivity.getProductRV()!!.adapter = ProductRV(productVideoCards as List<Product>)
                }
            })
    }

    override fun getLifecycle(): Lifecycle {
        return ProductActivity.lifecycle!!
    }
}