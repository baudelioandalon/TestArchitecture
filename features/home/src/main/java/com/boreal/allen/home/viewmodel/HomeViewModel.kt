package com.boreal.allen.home.viewmodel

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.boreal.allen.home.usecase.UsersUseCase
import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.EmptyIn
import com.boreal.allen.core.domain.StatusRequestEnum
import com.boreal.allen.core.domain.UseCase
import com.boreal.allen.core.domain.entity.UsersResponse
import com.boreal.allen.core.utils.CUBaseViewModel
import kotlinx.coroutines.flow.catch

class HomeViewModel(
    private val getUsersUseCase: UseCase<UsersUseCase.Input, UsersUseCase.Output>,
): CUBaseViewModel() {

    val usersList: LiveData<DataResponse<UsersResponse>>
        get() = _usersList
    private val _usersList =
        MutableLiveData<DataResponse<UsersResponse>>()

    fun requestGetUsers() {
        executeFlow {
            if (_usersList.value?.status == StatusRequestEnum.LOADING) {
                return@executeFlow
            }
            _usersList.value = DataResponse(status = StatusRequestEnum.LOADING)
            getUsersUseCase.execute(
                UsersUseCase.Input(EmptyIn)
            ).catch { cause: Throwable ->
                cause
                _usersList.value = DataResponse(
                    status = StatusRequestEnum.FAILURE,
                    failure = "Algo salio mal"
                )
            }.collect {
                _usersList.value = it.response
            }
        }
    }
}