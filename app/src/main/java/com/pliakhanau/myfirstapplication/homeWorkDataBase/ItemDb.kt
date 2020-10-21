package com.pliakhanau.myfirstapplication.homeWorkDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shop.Item
import com.pliakhanau.myfirstapplication.homeWorkDataBase.dao.ItemDao

@Database(entities = [Item::class], version = 1)
abstract class ItemDb : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}

object db {
    fun getDb(ctx: Context) =
        Room.databaseBuilder(ctx, ItemDb::class.java, "ItemDataBase").fallbackToDestructiveMigration().build()
}