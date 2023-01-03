package com.boreal.allen.profile.ui.personal

import com.boreal.allen.profile.R
import com.boreal.allen.profile.databinding.PersonalFragmentBinding
import com.boreal.allen.profile.viewmodel.ProfileViewModel
import com.boreal.commonutils.base.CUBaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PersonalFragment : CUBaseFragment<PersonalFragmentBinding>() {

    val viewModel : ProfileViewModel by sharedViewModel()

    override fun getLayout() = R.layout.personal_fragment

    override fun initView() {
        initElements()
    }
}