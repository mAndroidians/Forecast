package com.awsm.forecastapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.awsm.forecastapp.R
import dagger.android.support.DaggerFragment

class SettingFragment :DaggerFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return LayoutInflater.from(context).inflate(R.layout.fragment_setting, container, false)
    }
}