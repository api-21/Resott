package com.taknikinigga.resotts.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.Networking.Model.GroupModel
import kotlinx.android.synthetic.main.group_layout.view.*

class GroupRecyclerAdapter(val itemGroupModel: List<GroupModel>) :
    RecyclerView.Adapter<GroupRecyclerAdapter.GroupItemViewHolder>() {

    companion object {
        private const val VERTICAL = 0
        private const val HORIZONTAL = 1
    }

    inner class GroupItemViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.group_layout, parent, false)
        return GroupItemViewHolder(view,)
    }

    override fun onBindViewHolder(holder: GroupItemViewHolder, position: Int) {

        holder.itemView.apply {

            group_title.text = itemGroupModel[position].title

            if (!itemGroupModel[position].titleVisibilty){
                group_title.visibility = View.GONE
            }else{
                group_title.visibility = View.VISIBLE
            }

            val itemModeldata = itemGroupModel[position].ItemModel
            val adapter = ItemLayoutAdapter(itemModeldata)
            group_recycler_view.adapter = adapter
            if (itemGroupModel[position].orientation == VERTICAL) {
                group_recycler_view.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter.notifyDataSetChanged()
            } else {
                group_recycler_view.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter.notifyDataSetChanged()
            }

        }

    }

    override fun getItemCount(): Int {
        return itemGroupModel.size
    }

/*    interface getOnClickListener {
        fun onClick(position: Int)
    }*/
}