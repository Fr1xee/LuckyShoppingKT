package com.example.luckyshopping.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.luckyshopping.MainActivity
import com.example.luckyshopping.ProductLifecycle
import com.example.luckyshopping.R
import com.example.luckyshopping.pojo.Product
import com.example.luckyshopping.vm.ProductViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ProductActivity : AppCompatActivity() {

    var category: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        productRV = findViewById(R.id.rv_product)
        productRV!!.layoutManager = LinearLayoutManager(this)
        val intent: Intent = intent
        Companion.lifecycle = lifecycle
        val productLifecycle = ProductLifecycle()
        lifecycle.addObserver(productLifecycle)
        productViewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        appContext = applicationContext
        getDataFromDB(intent.getStringExtra("category"))
    }

    private fun getDataFromDB(category: String?) {
        this.category = category
        count = 0
        val vListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var snapshot: DataSnapshot = snapshot
                productViewModel!!.deleteVideoCards()
                var path = ""
                when (category) {
                    "cat_motherboards" -> path = "motherboard"
                    "cat_processors" -> path = "processors"
                    "cat_RAM_memory" -> path = "ram"
                    "cat_ssd" -> path = "ssd"
                    "cat_video_cards" -> path = "video_card"
                }
                snapshot = snapshot.child("/$path")
                for (ds in snapshot.children) {
                    val products = Product()
                    products.videoCardName = ds.child("name").value.toString()
                    products.price = ds.child("price").value.toString()
                    products.videoCardCapacity = ds.child("capacity").value.toString()
                    products.videoMemoryType = ds.child("type").value.toString()
                    products.url = ds.child("image").value.toString()
                    productViewModel!!.insertProduct(products)
                    count++
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        }
        MainActivity.ref!!.addValueEventListener(vListener)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    @SuppressLint("NonConstantResourceId")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.cat_processors -> {
                if (category != "cat_processors") {
                    getDataFromDB("cat_processors")
                }
                return true
            }
            R.id.cat_motherboards -> {
                if (category != "cat_motherboards") {
                    getDataFromDB("cat_motherboards")
                }
                return true
            }
            R.id.cat_ssd -> {
                if (category != "cat_ssd") {
                    getDataFromDB("cat_ssd")
                }
                return true
            }
            R.id.cat_RAM_memory -> {
                if (category != "cat_RAM_memory") {
                    getDataFromDB("cat_RAM_memory")
                }
                return true
            }
            R.id.cat_video_cards -> {
                if (category != "cat_video_cards") {
                    getDataFromDB("cat_video_cards")
                }
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private var productRV: RecyclerView? = null
        var productViewModel: ProductViewModel? = null
        var appContext: Context? = null
            private set
        var lifecycle: Lifecycle? = null
        var count = 0
            private set

        fun getProductRV(): RecyclerView? {
            return productRV
        }

    }
}