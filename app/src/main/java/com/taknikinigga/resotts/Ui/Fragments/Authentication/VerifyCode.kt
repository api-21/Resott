package com.taknikinigga.resotts.Ui.Fragments.Authentication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.taknikinigga.resotts.Ui.Activities.HomeActivity
import com.taknikinigga.resotts.R
import kotlinx.android.synthetic.main.verification_layout.*

class VerifyCode : Fragment(R.layout.verification_layout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnVerifyOtp.setOnClickListener {

            startActivity(Intent(context, HomeActivity::class.java))

        }
    }


}
