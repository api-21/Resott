package com.taknikinigga.myapplication.model

data class GroupModel(val orientation: Int, val title: String, val ItemModel: List<ItemModel>)

data class ItemModel(
    val viewType: Int = 0,
    val name: String? = null,
    val description: String? = null,
    val rating: Int = 0,
    val image: Int,
    val price: String? = null
)