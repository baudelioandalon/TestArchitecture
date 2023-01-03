package com.boreal.allen.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Registered(
    val age: Int? = 0,
    val date: String? = ""
) : Parcelable