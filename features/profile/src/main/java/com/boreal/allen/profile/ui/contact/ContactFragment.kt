package com.boreal.allen.profile.ui.contact

import com.boreal.allen.profile.R
import com.boreal.allen.profile.databinding.ContactFragmentBinding
import com.boreal.allen.profile.viewmodel.ProfileViewModel
import com.boreal.commonutils.base.CUBaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ContactFragment : CUBaseFragment<ContactFragmentBinding>() {

    val viewModel : ProfileViewModel by sharedViewModel()

    override fun getLayout() = R.layout.contact_fragment

    override fun initView() {
        initElements()
    }
}