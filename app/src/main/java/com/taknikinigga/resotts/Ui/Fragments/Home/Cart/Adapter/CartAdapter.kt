package com.taknikinigga.resotts.Ui.Fragments.Home.Cart.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taknikinigga.resotts.Networking.room.ItemCart
import com.taknikinigga.resotts.R
import kotlinx.android.synthetic.main.cart_item_lyt.view.*

class CartAdapter(val itemCart:List<ItemCart>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemview:View):RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item_lyt,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.itemView.apply {
            val item = itemCart[position]
            cItemCount.text = item.itemCount
            cItemName.text = item.itemName
            cItemPrice.text = item.itemPrice
        }
    }

    override fun getItemCount(): Int {
        return itemCart.size
    }
}