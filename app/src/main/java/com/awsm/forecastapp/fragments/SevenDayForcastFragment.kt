package com.awsm.forecastapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.awsm.forecastapp.R
import com.awsm.forecastapp.databinding.FragmentSevenDaysBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SevenDayForcastFragment : DaggerFragment() {

    private lateinit var binding : FragmentSevenDaysBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentSevenDaysBinding>(inflater,R.layout.fragment_seven_days,container,false)

        binding.lifecycleOwner = this
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}