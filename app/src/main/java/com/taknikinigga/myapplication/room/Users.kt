package com.taknikinigga.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "register_users")
data class Users(val username:String, val email:String, val password:String, val number:String, @PrimaryKey (autoGenerate = true)val id:Int=0)

@Entity(tableName = "restro_foods")
data class RestroFoods(val f_name:String, val f_price:String, val f_description:String)