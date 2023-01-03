package com.boreal.allen.ui

import androidx.navigation.NavController
import com.boreal.allen.R
import com.boreal.allen.databinding.ActivityMainBinding
import com.boreal.commonutils.base.CUBaseActivity

class MainActivity : CUBaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        initElements()
    }
}