package com.taknikinigga.resotts.Ui.Fragments.Home.Cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.Ui.Fragments.Home.Cart.Adapter.CartAdapter
import com.taknikinigga.resotts.Ui.Fragments.Home.Viewmodel.ResottViewmodel
import com.taknikinigga.resotts.Utils.toast
import com.taknikinigga.resotts.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.add_promo_code.*

@AndroidEntryPoint
class Cart : Fragment() {

    lateinit var binding: FragmentCartBinding
    val cartViewModel : ResottViewmodel by viewModels()
//    val args : CartArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = inflate(inflater, R.layout.fragment_cart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        val item = args.cartItem
//        context?.toast("${item.itemCount}, ${item.itemName}, ${item.itemPrice}")

         getCartItemFromDb()

        val edtPromoCode = EditText(context)
        edtPromoCode.hint = "Enter Your Promo Code"
        val lp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )
        edtPromoCode.layoutParams = lp
        edtPromoCode.setPadding(16)

        val cardDialog = MaterialAlertDialogBuilder(requireContext())
        cardDialog.setIcon(R.drawable.ic_baseline_local_offer_24)
        cardDialog.setView(edtPromoCode)

        cardAddPromoCode.setOnClickListener {
            cardDialog.setTitle("Enter Your Promo Code")

            cardDialog.setNegativeButton("Cancle") { dialogInterface, _ ->
                dialogInterface.dismiss()
                (edtPromoCode.parent as ViewGroup).removeView(edtPromoCode)
            }
            cardDialog.setPositiveButton("Ok") { dialogInterface, _ ->
                dialogInterface.dismiss()
                val promoCode = edtPromoCode.text
                (edtPromoCode.parent as ViewGroup).removeView(edtPromoCode)
                if (promoCode.isNullOrEmpty()){
                    return@setPositiveButton
                }else{
                    Toast.makeText(context, "$promoCode", Toast.LENGTH_SHORT).show()
                }

            }
            cardDialog.show()

        }

    }

    private fun getCartItemFromDb() {
        cartViewModel.getCartItem().observeForever {
            val adapter = CartAdapter(it)
            binding.cRCV.layoutManager = LinearLayoutManager(context)
            binding.cRCV.adapter = adapter
        }
    }


}