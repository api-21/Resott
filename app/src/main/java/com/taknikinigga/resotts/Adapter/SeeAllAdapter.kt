package com.taknikinigga.resotts.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.taknikinigga.resotts.Networking.Model.ItemModel
import com.taknikinigga.resotts.R
import kotlinx.android.synthetic.main.restro_layout.view.*

class SeeAllAdapter(val itemModel: List<ItemModel>) :
    RecyclerView.Adapter<SeeAllAdapter.SeeAllViewHolder>() {

    inner class SeeAllViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeeAllViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.restro_layout, parent, false)
        return SeeAllViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeeAllViewHolder, position: Int) {
        val item = itemModel[position]

        holder.itemView.apply {
            restro_image.setImageResource(item.image)
            restro_name.text = item.name
            restro_desc.text = item.description
            restro_rating.rating = item.rating.toFloat()

            setOnClickListener {

                findNavController().navigate(R.id.action_seeAll_to_placeOrder)
            }
        }
    }

    override fun getItemCount(): Int {
       return itemModel.size
    }


}