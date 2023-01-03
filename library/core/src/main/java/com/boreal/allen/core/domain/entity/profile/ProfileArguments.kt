package com.boreal.allen.core.domain.entity.profile

import android.os.Parcelable
import com.boreal.allen.core.domain.entity.UserModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileArguments(
    val profileModel: UserModel
) : Parcelable