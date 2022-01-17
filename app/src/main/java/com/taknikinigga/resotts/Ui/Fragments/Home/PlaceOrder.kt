package com.taknikinigga.resotts.Ui.Fragments.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taknikinigga.resotts.Networking.Model.ItemModel
import com.taknikinigga.resotts.Adapter.SeeAllAdapter
import com.taknikinigga.resotts.Networking.room.ItemCart
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.Ui.Fragments.Home.Viewmodel.ResottViewmodel

import com.taknikinigga.resotts.databinding.FragmentPlaceCartBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlaceOrder : Fragment() {

    lateinit var binding: FragmentPlaceCartBinding
    private val cartViewModel:ResottViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = inflate(inflater, R.layout.fragment_place_cart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddTCart.setOnClickListener {
            val itemName = binding.pcItemName.text.toString()
            val itemPrice = binding.pcItemPrice.text.toString()
            val itemCount = binding.pcTxtCount.text.toString()
            val cartItem = ItemCart(0,itemName,itemPrice,itemCount)

            //Adding to Cart Function
            addCartItemToDatabase(cartItem)

        }

        var item =-0


        binding.removeCartItem.setOnClickListener {
            if (item!=0){
                item--
                binding.pcTxtCount.text="$item"
            }else{
                Toast.makeText(context, "Cart Is Empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cartAddItem.setOnClickListener {
            when {
                item<=9 -> {
                    item++
                    binding.pcTxtCount.text="$item"
                }

                else -> {
                    Toast.makeText(context, "You can add only 10 items at a time", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val setDesert = listOf(
            ItemModel(1, "hotel 1", "lucknow", 3, R.drawable.chocolate),
            ItemModel(1, "Hotel 2", "Delhi", 4, R.drawable.chocolate),
            ItemModel(1, "Hotel 3", "Delhi", 5, R.drawable.chocolate),
            ItemModel(1, "Hotel 4", "Delhi", 2, R.drawable.chocolate),
            ItemModel(1, "Hotel 5", "Delhi", 1, R.drawable.chocolate)
        )

        binding.placeOrderRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        val placeOrderAdapter = SeeAllAdapter(setDesert)
        binding.placeOrderRecyclerView.adapter = placeOrderAdapter
        placeOrderAdapter.notifyDataSetChanged()

    }

    private fun addCartItemToDatabase(cartItem: ItemCart) = CoroutineScope(Dispatchers.Main).launch {

        cartViewModel.addToCart(cartItem)
        val action = PlaceOrderDirections.actionPlaceOrderToNavCart(cartItem)
        findNavController().navigate(action)

    }
}