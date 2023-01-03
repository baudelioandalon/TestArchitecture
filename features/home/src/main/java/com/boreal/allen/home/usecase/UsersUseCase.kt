package com.boreal.allen.home.usecase

import com.boreal.allen.core.domain.*
import com.boreal.allen.core.domain.entity.UsersResponse
import com.boreal.allen.home.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UsersUseCase(private val usersRepository: UsersRepository) :
    UseCase<UsersUseCase.Input, UsersUseCase.Output> {

    class Input(
        val emptyIn: EmptyIn
    ) : In()

    inner class Output(val response: DataResponse<UsersResponse>) :
        Out()

    override suspend fun execute(input: Input): Flow<Output> {
        return usersRepository.executeGetUsers(emptyIn = input.emptyIn)
            .flowOn(Dispatchers.IO).map {
                Output(it)
            }
    }

}