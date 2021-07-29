package com.taknikinigga.myapplication.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun createUser(users: Users)

    @Query("SELECT * FROM register_users ORDER BY id ASC")
    fun getAllUserData(): LiveData<List<Users>>

}