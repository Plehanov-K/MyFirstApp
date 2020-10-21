package com.pliakhanau.myfirstapplication.homeWorkDataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shop.Item

@Dao
interface ItemDao {

    @Insert
    suspend fun addItem(item: Item)

    @Query("SELECT * FROM item_table")
    suspend fun getAllItem(): List<Item>
}