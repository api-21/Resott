package com.taknikinigga.resotts.Ui.Fragments.Home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.Adapter.GroupRecyclerAdapter
import com.taknikinigga.resotts.Networking.Model.GroupModel
import com.taknikinigga.resotts.Networking.Model.ItemModel
import com.taknikinigga.resotts.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, R.layout.fragment_home, container, false)
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

        val setAdsItem = listOf(
            ItemModel(2, "", "", 0, R.drawable.food),
            ItemModel(2, "", "", 0, R.drawable.food)
        )

        val setLayoutItemToGroupAdapter = listOf(
            GroupModel(false,1, "", setCityLayout),

            GroupModel(true,1, "Ads Layout", setAdsItem),
            GroupModel(true,1, "", setFoodLayout),
            GroupModel(true,1, "Trending Now", setFoodLayout),

            )


        home_frag_recycler.layoutManager = LinearLayoutManager(context)
        val adapter = GroupRecyclerAdapter(setLayoutItemToGroupAdapter)
        home_frag_recycler.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

}