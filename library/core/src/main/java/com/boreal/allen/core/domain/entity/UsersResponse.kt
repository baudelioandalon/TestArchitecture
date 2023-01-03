package com.boreal.allen.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UsersResponse(
    val info: Info,
    val results: List<UserModel>
): Parcelable