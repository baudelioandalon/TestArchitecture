package com.boreal.allen.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val cell: String? = "",
    val dob: Dob,
    val email: String? = "",
    val gender: String? = "",
    val id: Id? = Id(),
    val location: Location,
    val login: Login? = Login(),
    val name: Name? = Name(),
    val nat: String? = "",
    val phone: String? = "",
    val picture: Picture = Picture(),
    val registered: Registered = Registered()
) : Parcelable