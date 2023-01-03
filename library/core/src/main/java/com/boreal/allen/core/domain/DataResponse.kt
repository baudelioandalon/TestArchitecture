package com.boreal.allen.core.domain

data class DataResponse<R>(
    val response: R? = null,
    val failure: String? = null,
    val status: StatusRequestEnum = StatusRequestEnum.NONE
)