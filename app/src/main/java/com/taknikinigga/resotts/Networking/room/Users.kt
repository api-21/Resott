package com.taknikinigga.resotts.Networking.room

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "register_users")
data class Users(
    val username: String,
    val email: String,
    val password: String,
    val number: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

@Entity(tableName = "restro_foods")
data class ResottFoods(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val f_name: String,
    val f_price: String,
    val f_description: String)

@Parcelize
@Entity(tableName = "cart")
data class ItemCart(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val itemName: String,
    val itemPrice: String,
    val itemCount:String
):Parcelable

@Parcelize
@Entity(tableName = "credit_card")
data class CreditCards(
    val cardHolderName:String,
    val cvv:Int,
    val expiry:Int,
    val cardNumber:Long,
):Parcelable