package com.boreal.allen.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
): Parcelable