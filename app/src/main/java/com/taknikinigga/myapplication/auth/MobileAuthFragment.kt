package com.taknikinigga.myapplication.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.taknikinigga.myapplication.R
import kotlinx.android.synthetic.main.app_bar_layout.*
import kotlinx.android.synthetic.main.mobile_auth_layout.*

class MobileAuthFragment : Fragment(R.layout.mobile_auth_layout) {

    //private val args : MobileAuthFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btnLogin.setOnClickListener {

                val action = MobileAuthFragmentDirections.actionMobileAuthenticationToVerifyCode()
                findNavController().navigate(action)

        }
    }
}
