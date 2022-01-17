package com.taknikinigga.resotts.Networking.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ResottDao {
    @Insert
    suspend fun createUser(users: Users)

    @Query("SELECT * FROM register_users")
    fun getAllUserData(): LiveData<List<Users>>

    @Insert
    suspend fun addToCart(itemCart: ItemCart)

    @Query("SELECT * FROM cart ORDER BY id ASC")
    fun getCartItem() : LiveData<List<ItemCart>>

    //Cart Item Dao
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun addToCart(cart: ItemCart)
//
//    @Query("SELECT * FROM cart ORDER BY id ASC")
//    fun getCartItem():List<ItemCart>

//    @Query("DELETE FROM cart WHERE id")
//    fun deleteCartItem()

}