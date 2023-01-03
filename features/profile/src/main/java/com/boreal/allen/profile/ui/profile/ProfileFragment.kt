package com.boreal.allen.profile.ui.profile

import com.boreal.allen.profile.R
import com.boreal.allen.profile.databinding.ProfileFragmentBinding
import com.boreal.allen.profile.viewmodel.ProfileViewModel
import com.boreal.commonutils.base.CUBaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProfileFragment: CUBaseFragment<ProfileFragmentBinding>() {

    val viewModel : ProfileViewModel by sharedViewModel()

    override fun getLayout() = R.layout.profile_fragment

    override fun initView() {
        initElements()
    }
}