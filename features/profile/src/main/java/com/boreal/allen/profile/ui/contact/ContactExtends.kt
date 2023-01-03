package com.boreal.allen.profile.ui.contact

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.findNavController
import com.boreal.commonutils.extensions.onClick


fun ContactFragment.initElements() {
    binding.apply {
        viewModel.getData()?.let { data ->
            tvHomeNumber.text = data.profileModel.phone.orEmpty()
            tvCellNumber.text = data.profileModel.cell.orEmpty()
            tvLocation.text = data.profileModel.location.getLocation()
            roundableOpenMap.onClick {
                val mapUri: Uri =
                    Uri.parse("geo:0,0?q=${data.profileModel.location.getLatitude()},${data.profileModel.location.getLongitude()}(Location)")
                val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        }
        btnBack.onClick {
            findNavController().navigateUp()
        }
    }
}