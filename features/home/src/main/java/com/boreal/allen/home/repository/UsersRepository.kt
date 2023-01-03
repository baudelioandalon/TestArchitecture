package com.boreal.allen.home.repository

import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.EmptyIn
import com.boreal.allen.core.domain.entity.UsersResponse
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun executeGetUsers(
        emptyIn: EmptyIn
    ): Flow<DataResponse<UsersResponse>>
}