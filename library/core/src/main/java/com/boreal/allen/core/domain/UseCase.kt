package com.boreal.allen.core.domain

import kotlinx.coroutines.flow.Flow

interface UseCase<in I : In, out O> {
    suspend fun execute(input: I): Flow<O>
}

sealed interface Port
open class In : Port
open class Out : Port
object EmptyIn : In()
object EmptyOut : Out()