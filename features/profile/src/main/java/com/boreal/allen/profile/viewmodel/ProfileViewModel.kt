package com.boreal.allen.profile.viewmodel

import com.boreal.allen.core.domain.entity.profile.ProfileArguments
import com.boreal.allen.core.utils.CUBaseViewModel

class ProfileViewModel : CUBaseViewModel() {

    lateinit var profileData: ProfileArguments

    fun setData(profileArguments: ProfileArguments) {
        this.profileData = profileArguments
    }

    fun getData() = if (this::profileData.isInitialized) {
        this.profileData
    } else {
        null
    }
}