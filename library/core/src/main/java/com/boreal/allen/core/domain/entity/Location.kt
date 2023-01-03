package com.boreal.allen.core.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val city: String?,
    val coordinates: Coordinates?,
    val country: String?,
    val postcode: Int?,
    val state: String?,
    val street: Street?,
    val timezone: Timezone?
) : Parcelable {
    fun getLocation() = "${street?.name} ${street?.number}, $city, $state, $country, $postcode"
    fun getLatitude() =  "${coordinates?.latitude}"
    fun getLongitude() =  "${coordinates?.longitude}"
}