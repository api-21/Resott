package com.taknikinigga.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.taknikinigga.myapplication.R
import com.taknikinigga.myapplication.adapter.GroupRecyclerAdapter
import com.taknikinigga.myapplication.model.GroupModel
import com.taknikinigga.myapplication.model.ItemModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val setCityLayout = listOf(
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_edit_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_favorite_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp)
        )

        val setFoodLayout = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.google_plus_share_social_icon),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.facebook_icon),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.google_plus_share_social_icon),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.facebook_icon),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.google_plus_share_social_icon)
        )

        val setAdsItem = listOf(
            ItemModel(2, "", "", 0, R.drawable.ic_android_black_24dp),
            ItemModel(2, "", "", 0, R.drawable.ic_android_black_24dp)
        )

        val setLayoutItemToGroupAdapter = listOf(
            GroupModel(1, "Trending Now", setFoodLayout),
            GroupModel(1, "", setCityLayout),
            GroupModel(1, "Ads Layout", setAdsItem),
            GroupModel(1, "Trending Now", setFoodLayout),

            )


        home_frag_recycler.layoutManager = LinearLayoutManager(context)
        val adapter = GroupRecyclerAdapter(setLayoutItemToGroupAdapter, this)
        home_frag_recycler.adapter = adapter
        adapter.notifyDataSetChanged()

    }

}