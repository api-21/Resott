package com.taknikinigga.resotts.Ui.Fragments.Home

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.Adapter.GroupRecyclerAdapter
import com.taknikinigga.resotts.Networking.Model.GroupModel
import com.taknikinigga.resotts.Networking.Model.ItemModel
import com.taknikinigga.resotts.databinding.SearchFragmentBinding
import kotlinx.android.synthetic.main.search_fragment.*

class Search : Fragment() {

    lateinit var binding : SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater,R.layout.search_fragment,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    
        val setCityLayout = listOf(
            ItemModel(0, "", "", 0, R.drawable.food),
            ItemModel(0, "", "", 0, R.drawable.food),
            ItemModel(0, "", "", 0, R.drawable.food),
            ItemModel(0, "", "", 0, R.drawable.food),
            ItemModel(0, "", "", 0, R.drawable.food)
        )

        val setFoodLayout = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.food),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.food),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.food),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.food),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.food)
        )

        val setLayoutItemToGroupAdapter = listOf(
            GroupModel(false,1, "", setCityLayout),
            GroupModel(false,1, "", setFoodLayout),
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