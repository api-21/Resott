package com.taknikinigga.resotts.Ui.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import com.taknikinigga.resotts.R
import com.taknikinigga.resotts.databinding.FilterFragmentBinding

class Filter : Fragment() {

    lateinit var binding: FilterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, R.layout.filter_fragment, container, false)
        return binding.root
    }
}