package com.taknikinigga.resotts.Ui.Fragments.Authentication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.taknikinigga.resotts.R
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
