package com.boreal.allen.home.data.datasource

import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.entity.UsersResponse

interface GetUsersDataSource {
    suspend fun executeGetUsers(): DataResponse<UsersResponse>
}