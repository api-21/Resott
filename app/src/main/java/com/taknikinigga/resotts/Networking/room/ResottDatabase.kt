package com.taknikinigga.resotts.Networking.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class,ItemCart::class), version = 1, exportSchema = false)
abstract class ResottDatabase : RoomDatabase() {
    abstract fun getDao(): ResottDao
}