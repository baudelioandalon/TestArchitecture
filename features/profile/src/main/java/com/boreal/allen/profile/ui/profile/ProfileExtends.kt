package com.boreal.allen.profile.ui.profile

import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.boreal.allen.core.MODEL_PROFILE
import com.boreal.allen.core.domain.entity.profile.ProfileArguments
import com.boreal.allen.core.utils.getDay
import com.boreal.allen.core.utils.getMonth
import com.boreal.allen.core.utils.getYear
import com.boreal.allen.core.utils.toTimestamp
import com.boreal.allen.uisystem.R
import com.boreal.commonutils.extensions.onClick
import com.boreal.allen.profile.R as profileR

fun ProfileFragment.initElements() {
    binding.apply {
        val args = arguments?.get(MODEL_PROFILE)
        args?.let {
            viewModel.setData(it as ProfileArguments)
            viewModel.getData()?.let { data ->
                userProfile = with(data.profileModel) {
                    this.picture.large ?: this.picture.medium ?: this.picture.thumbnail
                }
                setBirthday(data)
                setGenre(data)
                setNameAndCity(data)
                setMemberSince(data)
            }
            btnPersonal.onClick {
                findNavController().navigate(profileR.id.personalFragment)
            }
            btnContact.onClick {
                findNavController().navigate(profileR.id.contactFragment)
            }
            btnBack.onClick {
                findNavController().navigateUp()
            }
        }
    }
}

fun ProfileFragment.setMemberSince(data: ProfileArguments) {
    binding.apply {
        tvMemberSince.text =
            getString(R.string.since_holder, (data.profileModel.registered.age ?: 0).toString())
    }
}

fun ProfileFragment.setBirthday(data: ProfileArguments) {
    binding.apply {
        tvDay.text = data.profileModel.dob.date.toTimestamp().getDay()
        tvMonth.text = data.profileModel.dob.date.toTimestamp().getMonth()
        tvYear.text = data.profileModel.dob.date.toTimestamp().getYear()
    }
}

fun ProfileFragment.setNameAndCity(data: ProfileArguments) {
    binding.apply {
        tvNames.text = getString(
            R.string.name_holder,
            data.profileModel.name?.title.orEmpty(),
            data.profileModel.name?.first.orEmpty()
        )
        tvLastname.text = data.profileModel.name?.last.orEmpty()
        txtCity.text = data.profileModel.nat.orEmpty()
    }
}

fun ProfileFragment.setGenre(data: ProfileArguments) {
    binding.apply {
        val layoutParams = btnMan.layoutParams
        val layoutParamsOther = btnWoman.layoutParams

        if (data.profileModel.gender == "male") {
            layoutParams.width = 150
            layoutParams.height = 150
            btnMan.layoutParams = layoutParams

            layoutParamsOther.width = 110
            layoutParamsOther.height = 110

            val param = btnWoman.layoutParams as ViewGroup.MarginLayoutParams
            param.setMargins(0, 0, 25, 0)
            btnWoman.layoutParams = layoutParamsOther
            btnWoman.layoutParams = param
        } else {
            layoutParams.width = 150
            layoutParams.height = 150
            btnWoman.layoutParams = layoutParams

            layoutParamsOther.width = 110
            layoutParamsOther.height = 110
            btnMan.layoutParams = layoutParamsOther
        }
    }
}