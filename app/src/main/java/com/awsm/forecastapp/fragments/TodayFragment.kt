package com.awsm.forecastapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.awsm.forecastapp.R
import com.awsm.forecastapp.data.util.ApiEmptyResponse
import com.awsm.forecastapp.data.util.ApiErrorResponse
import com.awsm.forecastapp.data.util.ApiSuccessResponse
import com.awsm.forecastapp.data.util.Status
import com.awsm.forecastapp.databinding.TodayFragmentBinding
import com.awsm.forecastapp.util.showProgressBar
import com.awsm.forecastapp.util.showSnack
import com.awsm.forecastapp.util.showToast
import com.google.gson.Gson
import dagger.android.support.DaggerFragment

import javax.inject.Inject

class TodayFragment : DaggerFragment() {


    @Inject lateinit var viewModelProvider: ViewModelProvider.Factory
    @Inject lateinit var gson: Gson


    private lateinit var viewModel: TodayViewModel

    private lateinit var binding : TodayFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.today_fragment,container,false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
         viewModel = ViewModelProviders.of(this, viewModelProvider).get(TodayViewModel::class.java)
         binding.vm = viewModel

          viewModel.getUserInformation()
            .observe(this, Observer {
               when(it){
                   is ApiErrorResponse ->{
                       binding.progressBar.showProgressBar(false,activity?.window!!)
                       binding.root.showSnack("No data")
                   }
                   is ApiEmptyResponse ->{
                       binding.progressBar.showProgressBar(false,activity?.window!!)

                       binding.root.showSnack("No data")
                   }
                   is ApiSuccessResponse ->{
                       binding.progressBar.showProgressBar(false,activity?.window!!)

                       viewModel.setInformation(it.body.location,it.body.current)
                   }
               }

            })


    }

}
