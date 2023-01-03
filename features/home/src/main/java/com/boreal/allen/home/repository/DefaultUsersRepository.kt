package com.boreal.allen.home.repository

import com.boreal.allen.core.domain.EmptyIn
import com.boreal.allen.home.data.datasource.GetUsersDataSource
import kotlinx.coroutines.flow.flow

class DefaultUsersRepository(
    private val getUsersDataSource: GetUsersDataSource
) : UsersRepository {

    override suspend fun executeGetUsers(emptyIn: EmptyIn) = flow {
        emit(getUsersDataSource.executeGetUsers())
    }

}