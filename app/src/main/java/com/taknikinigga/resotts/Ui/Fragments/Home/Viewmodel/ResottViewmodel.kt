package com.taknikinigga.resotts.Ui.Fragments.Home.Viewmodel

import androidx.lifecycle.ViewModel
import com.taknikinigga.resotts.Networking.room.ItemCart
import com.taknikinigga.resotts.Networking.room.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ResottViewmodel @Inject constructor(val resottRepo: Repository) : ViewModel() {

    suspend fun addToCart(itemCart: ItemCart){
        resottRepo.addToCart(itemCart)
    }

    fun getCartItem() = resottRepo.getCartItem()

}