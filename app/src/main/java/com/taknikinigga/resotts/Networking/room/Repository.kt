package com.taknikinigga.resotts.Networking.room

import androidx.lifecycle.LiveData
import javax.inject.Inject

class Repository @Inject constructor( val resottDo: ResottDao) {

    val readAllUsersData: LiveData<List<Users>> = resottDo.getAllUserData()

    fun getCartItem() = resottDo.getCartItem()

    suspend fun addUser(users: Users) {
        resottDo.createUser(users)
    }

    suspend fun addToCart(itemCart: ItemCart){
        resottDo.addToCart(itemCart)
    }

}