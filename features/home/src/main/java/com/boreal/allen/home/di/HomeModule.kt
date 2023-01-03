package com.boreal.allen.home.di

import com.boreal.allen.core.domain.UseCase
import com.boreal.allen.home.data.datasource.GetUsersDataSource
import com.boreal.allen.home.data.datasource.remote.RemoteUsersDataSource
import com.boreal.allen.home.repository.DefaultUsersRepository
import com.boreal.allen.home.repository.UsersRepository
import com.boreal.allen.home.usecase.UsersUseCase
import com.boreal.allen.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val homeModule = module {
    single<GetUsersDataSource>(named("RemoteUsersDataSource")) {
        RemoteUsersDataSource()
    }

    single<UsersRepository>(named("DefaultUsersRepository")) {
        DefaultUsersRepository(
            get(named("RemoteUsersDataSource"))
        )
    }

    single<UseCase<UsersUseCase.Input, UsersUseCase.Output>>(named("UsersUseCase")) {
        UsersUseCase(get(named("DefaultUsersRepository")))
    }

    viewModel {
        HomeViewModel(
            get(named("UsersUseCase"))
        )
    }
}