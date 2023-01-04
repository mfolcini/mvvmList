package com.nutmeg.core.domain.use_cases

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.annotations.Nullable
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

//abstract class BaseUseCase<Model, Params> {
//    abstract suspend fun buildRequest(@Nullable params: Params?): Model?
//    suspend fun execute(@Nullable params: Params?): Model? {
//        return try {
//            buildRequest(params)
//        } catch (excetpion: Exception){
//            null
//        }
//    }
//}

interface BaseUseCase<out Type, in Params> where Type : Any {

    val callbackDispatcher: CoroutineContext
        get() = Dispatchers.Main

    /**
     * Runs the actual logic of the use case.
     */
    suspend fun buildUseCase(params: Params?): Result<Type>

    suspend operator fun invoke(params: Params?, onSuccess: (Type) -> Unit, onFailure: (Throwable) -> Unit) {
        val result = buildUseCase(params)

        coroutineScope {
            launch(callbackDispatcher) {
                result.fold(
                    onFailure = onFailure,
                    onSuccess = onSuccess
                )
            }
        }
    }
}