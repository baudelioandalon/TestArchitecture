package com.boreal.allen.home.data.datasource.remote

import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.entity.UsersResponse
import com.boreal.allen.home.data.datasource.GetUsersDataSource

class RemoteUsersDataSource : GetUsersDataSource {
    override suspend fun executeGetUsers(): DataResponse<UsersResponse> {
        return UsersDataSource.getUsers()
    }
}
