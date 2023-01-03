package com.boreal.allen.home.data.datasource.remote

import com.boreal.allen.core.BuildConfig
import com.boreal.allen.core.domain.DataResponse
import com.boreal.allen.core.domain.StatusRequestEnum
import com.boreal.allen.core.domain.entity.UsersResponse
import com.boreal.allen.core.retrofit.InitServices
import com.boreal.allen.core.retrofit.ValidResponse
import retrofit2.Call
import java.net.UnknownHostException

class UsersDataSource {
    companion object {
        fun getUsers(): DataResponse<UsersResponse> = try {
            ValidResponse<UsersResponse>(UsersResponse::class).validationMethod(
                InitServices<Call<UsersResponse>>().executeService("${BuildConfig.BASE_URL}${BuildConfig.USERS}")
            )
        } catch (exception: Exception) {
            if (exception is UnknownHostException) {
                DataResponse(
                    status = StatusRequestEnum.FAILURE,
                    failure = "Por favor, revisa tu conexion a internet"
                )
            } else {
                DataResponse(
                    status = StatusRequestEnum.FAILURE,
                    failure = "No se pudo completar la transaccion, por favor intenta mas tarde"
                )
            }
        }
    }

}