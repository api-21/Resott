package com.taknikinigga.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taknikinigga.myapplication.R
import com.taknikinigga.myapplication.model.ItemModel
import kotlinx.android.synthetic.main.ads_layout.view.*
import kotlinx.android.synthetic.main.city_layout.view.*
import kotlinx.android.synthetic.main.food_layout.view.*
import kotlinx.android.synthetic.main.restro_layout.view.*

class ItemLayoutAdapter(val itemModel: List<ItemModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val CITY_LAYOUT = 0
        private const val RESTRO_LAYOUT = 1
        private const val ADS_LAYOUT = 2
        private const val FOODS_LAYOUT = 3
    }

    inner class CityLayoutViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemModel) {
            val image = postModel.image
            itemView.city_img.setImageResource(image)
        }
    }

    inner class RestroLayoutViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemModel) {
            val image = postModel.image
            itemView.apply {
                restro_image.setImageResource(image)
                restro_name.text = postModel.name
                restro_desc.text = postModel.description
                restro_rating.rating = postModel.rating.toFloat()
            }


        }
    }

    inner class AdsLayoutViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemModel) {
            val image = postModel.image
            itemView.ads_image.setImageResource(image)
        }
    }

    inner class FoodsLayoutViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(postModel: ItemModel) {

            val image = postModel.image
            itemView.apply {
                fl_name.text = postModel.name
                fl_desc.text = postModel.description
                fl_image.setImageResource(image)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == CITY_LAYOUT) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.city_layout, parent, false)
            return CityLayoutViewHolder(view)
        } else if (viewType == RESTRO_LAYOUT) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.restro_layout, parent, false)
            return RestroLayoutViewHolder(view)
        } else if (viewType == ADS_LAYOUT) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.ads_layout, parent, false)
            return AdsLayoutViewHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.food_layout, parent, false)
            return FoodsLayoutViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return if (getItemViewType(position) == CITY_LAYOUT) {
            (holder as CityLayoutViewHolder).bind(itemModel[position])
        } else if (getItemViewType(position) == RESTRO_LAYOUT) {
            (holder as RestroLayoutViewHolder).bind(itemModel[position])
        } else if (getItemViewType(position) == ADS_LAYOUT) {
            (holder as AdsLayoutViewHolder).bind(itemModel[position])
        } else {
            (holder as FoodsLayoutViewHolder).bind(itemModel[position])
        }
    }

    override fun getItemCount(): Int {
        return itemModel.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemModel[position].viewType == 0) {
            CITY_LAYOUT
        } else if (itemModel[position].viewType == 1) {
            RESTRO_LAYOUT
        } else if (itemModel[position].viewType == 2) {
            ADS_LAYOUT
        } else {
            FOODS_LAYOUT
        }
    }

}