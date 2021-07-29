package com.taknikinigga.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Users::class), version = 1, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun getDao(): UsersDao

    companion object {

        @Volatile
        var INSTANCE: UserRoomDatabase? = null

        fun getRoomDatabase(context: Context): UserRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserRoomDatabase::class.java,
                    "register_users"
                ).build()
                INSTANCE = instance
                instance
            }
        }


    }

}