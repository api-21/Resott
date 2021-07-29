package com.taknikinigga.myapplication.fragments

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taknikinigga.myapplication.R
import com.taknikinigga.myapplication.adapter.GroupRecyclerAdapter
import com.taknikinigga.myapplication.model.GroupModel
import com.taknikinigga.myapplication.model.ItemModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.search_fragment.*

class Search : Fragment(R.layout.search_fragment) {

    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    
        val setCityLayout = listOf(
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_edit_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_favorite_black_24dp),
            ItemModel(0, "", "", 0, R.drawable.ic_android_black_24dp)
        )

        val setFoodLayout = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.ic_mail_black_24dp),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.ic_android_black_24dp),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.ic_home_black_24dp),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.ic_location_on_black_24dp),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.ic_android_black_24dp)
        )

        val setLayoutItemToGroupAdapter = listOf(
            GroupModel(1, "", setCityLayout),
            GroupModel(1, "", setFoodLayout),
        )

        search_recycler_view.layoutManager = LinearLayoutManager(context)
        val adapter = GroupRecyclerAdapter(setLayoutItemToGroupAdapter)
        search_recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)

        val searchView = menu.findItem(R.id.navSearch)
        if (searchView != null) {
            val searchItem = searchView.actionView as SearchView
            searchItem.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Toast.makeText(context, "$query", Toast.LENGTH_SHORT).show()
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {


                    return false
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
    }

}