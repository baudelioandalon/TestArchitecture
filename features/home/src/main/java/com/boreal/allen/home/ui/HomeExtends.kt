package com.boreal.allen.home.ui

import com.boreal.allen.core.domain.entity.UserModel

fun HomeFragment.initElements() {
    binding.apply {
        recyclerUsers.apply {
            adapter = adapterRecyclerUsers
            viewModel.requestGetUsers()
        }
    }
}

fun HomeFragment.loadRecyclerUsers(response: List<UserModel>) {
    adapterRecyclerUsers.submitList(response)
}