package com.example.luckyshopping.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
class Product {

    @PrimaryKey(autoGenerate = true)
    var id = 0
    var videoCardName: String? = null
    var price: String? = null
    var videoMemoryType: String? = null
    var videoCardCapacity: String? = null
    var url: String? = null

    @JvmName("getId1")
    fun getId(): Int {
        return id
    }

    @JvmName("setId1")
    fun setId(id: Int) {
        this.id = id
    }

    @JvmName("getVideoCardName1")
    fun getVideoCardName(): String? {
        return videoCardName
    }

    @JvmName("setVideoCardName1")
    fun setVideoCardName(videoCardName: String?) {
        this.videoCardName = videoCardName
    }

    @JvmName("getPrice1")
    fun getPrice(): String? {
        return price
    }

    @JvmName("setPrice1")
    fun setPrice(price: String?) {
        this.price = price
    }

    @JvmName("getVideoMemoryType1")
    fun getVideoMemoryType(): String? {
        return videoMemoryType
    }

    @JvmName("setVideoMemoryType1")
    fun setVideoMemoryType(videoMemoryType: String?) {
        this.videoMemoryType = videoMemoryType
    }

    @JvmName("getVideoCardCapacity1")
    fun getVideoCardCapacity(): String? {
        return videoCardCapacity
    }

    @JvmName("setVideoCardCapacity1")
    fun setVideoCardCapacity(videoCardCapacity: String?) {
        this.videoCardCapacity = videoCardCapacity
    }

    @JvmName("getUrl1")
    fun getUrl(): String? {
        return url
    }

    @JvmName("setUrl1")
    fun setUrl(url: String?) {
        this.url = url
    }
}