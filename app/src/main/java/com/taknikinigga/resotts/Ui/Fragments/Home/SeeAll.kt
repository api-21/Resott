package com.taknikinigga.resotts.Ui.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.taknikinigga.resotts.Networking.Model.ItemModel
import com.taknikinigga.resotts.Adapter.SeeAllAdapter
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.databinding.FragmentSeeAllBinding
import kotlinx.android.synthetic.main.fragment_see_all.*

class SeeAll : Fragment() {

    lateinit var binding: FragmentSeeAllBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflate(inflater, R.layout.fragment_see_all, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val foodChipGrpItem = resources.getStringArray(R.array.foodCategory)

        val setPizzaFood = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.pizza),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.pizza),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.pizza),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.pizza),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.pizza)
        )

        val setFood = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.food),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.food),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.food),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.food),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.food)
        )

        val setDesert = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.chocolate),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.chocolate),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.chocolate),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.chocolate),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.chocolate)
        )

        val setDrink = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.drink),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.drink),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.drink),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.drink),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.drink)
        )

        seeAllRecycler.layoutManager = GridLayoutManager(context,4,GridLayoutManager.VERTICAL,false)
        val adapterSeeAll = SeeAllAdapter(setPizzaFood)
        seeAllRecycler.adapter = adapterSeeAll
        adapterSeeAll.notifyDataSetChanged()


        for (text in foodChipGrpItem) {
            val chip = Chip(context)
            chip.text=text
            foodChipGrp.addView(chip)
            chip.setOnClickListener {
                when(chip.text){
                    "Pizza" ->{
                        val adapterSeeAll = SeeAllAdapter(setPizzaFood)
                        seeAllRecycler.adapter = adapterSeeAll
                        adapterSeeAll.notifyDataSetChanged()
                    }
                    "Pasta"->{

                        val adapterSeeAll = SeeAllAdapter(setFood)
                        seeAllRecycler.adapter = adapterSeeAll
                        adapterSeeAll.notifyDataSetChanged()
                    }
                    "Deserts"->{
                        val adapterSeeAll = SeeAllAdapter(setDesert)
                        seeAllRecycler.adapter = adapterSeeAll
                        adapterSeeAll.notifyDataSetChanged()
                    }
                    "Drink" ->{
                        val adapterSeeAll = SeeAllAdapter(setDrink)
                        seeAllRecycler.adapter = adapterSeeAll
                        adapterSeeAll.notifyDataSetChanged()
                    }
                }
            }
        }

    }
}