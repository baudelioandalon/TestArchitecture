package com.boreal.allen.profile.ui.personal

import androidx.navigation.fragment.findNavController
import com.boreal.allen.uisystem.R
import com.boreal.commonutils.extensions.onClick

fun PersonalFragment.initElements() {
    binding.apply {
        viewModel.getData()?.let { data ->
            tvNames.text = getString(
                R.string.name_holder,
                data.profileModel.name?.title.orEmpty(),
                data.profileModel.name?.first.orEmpty()
            )
            tvLastname.text = data.profileModel.name?.last.orEmpty()
            tvEmail.text = data.profileModel.email.orEmpty()
            tvAge.text =
                getString(R.string.since_holder, (data.profileModel.dob.age ?: 0).toString())
            tvNss.text = data.profileModel.id?.value.orEmpty()
        }
        btnBack.onClick {
            findNavController().navigateUp()
        }
    }
}