package com.example.luckyshopping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.luckyshopping.activity.ProductActivity
import com.google.firebase.database.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var buttonCategory1: Button? = null
    var buttonCategory2: Button? = null
    var buttonCategory3: Button? = null
    var buttonCategory4: Button? = null
    var buttonCategory5: Button? = null
    var startIntent: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCategory1 = findViewById(R.id.but_cat_1)
        buttonCategory2 = findViewById(R.id.but_cat_2)
        buttonCategory3 = findViewById(R.id.but_cat_3)
        buttonCategory4 = findViewById(R.id.but_cat_4)
        buttonCategory5 = findViewById(R.id.but_cat_5)
        buttonCategory1!!.setOnClickListener(this)
        buttonCategory2!!.setOnClickListener(this)
        buttonCategory3!!.setOnClickListener(this)
        buttonCategory4!!.setOnClickListener(this)
        buttonCategory5!!.setOnClickListener(this)
        firebaseDatabase = FirebaseDatabase.getInstance()
        ref = firebaseDatabase!!.getReference("categories")
    }

    @SuppressLint("NonConstantResourceId")
    override fun onClick(view: View) {
        when (view.id) {
            R.id.but_cat_1 -> setStartIntent("cat_motherboards")
            R.id.but_cat_2 -> setStartIntent("cat_processors")
            R.id.but_cat_3 -> setStartIntent("cat_RAM_memory")
            R.id.but_cat_4 -> setStartIntent("cat_video_cards")
            R.id.but_cat_5 -> setStartIntent("cat_ssd")
        }
    }

    private fun setStartIntent(category: String?) {
        startIntent = Intent(this, ProductActivity::class.java)
        startIntent!!.putExtra("category", category)
        startActivity(startIntent)
    }

    companion object {
        var firebaseDatabase: FirebaseDatabase? = null
        var ref: DatabaseReference? = null
    }
}