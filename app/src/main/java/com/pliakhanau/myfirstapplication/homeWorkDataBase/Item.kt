package com.example.shop

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @ColumnInfo(name = "item_name")
    val name: String,
    @ColumnInfo(name = "item_price")
    val price: String,
    @ColumnInfo(name = "item_image")
    val photoUrl: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}

