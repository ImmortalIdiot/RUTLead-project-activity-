package com.immortalidiot.rutlead.database

import com.immortalidiot.rutlead.BuildConfig
import com.immortalidiot.rutlead.di.Dispatcher
import com.immortalidiot.rutlead.util.Messages.NETWORK_ERROR
import com.immortalidiot.rutlead.util.Messages.SUCCESSFUL_REGISTRATION
import com.immortalidiot.rutlead.util.Messages.UNKNOWN_ERROR
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

interface StudentRepository {
    suspend fun registerStudent(student: Student): String
    suspend fun loginStudent(studentId: String, password: String): Result<Unit>
}

class StudentRepositoryImplementation @Inject constructor(
    @Dispatcher(Dispatcher.IO) private val ioDispatcher: CoroutineDispatcher
) : StudentRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(ServiceAPI::class.java)

    override suspend fun registerStudent(student: Student): String {
        return try {
            withContext(ioDispatcher) {
                val response = service.register(student).execute()

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null && responseBody.status == 201) {
                        SUCCESSFUL_REGISTRATION
                    } else {
                        responseBody?.errors?.values?.first()?.first() ?: UNKNOWN_ERROR
                    }
                } else {
                    response.errorBody()?.string() ?: UNKNOWN_ERROR
                }
            }
        } catch (e: Exception) { NETWORK_ERROR }
    }

    override suspend fun loginStudent(studentId: String, password: String): Result<Unit> {
        return try {
            withContext(ioDispatcher) {
                val response = service.auth(studentId, password).execute()

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null && responseBody.status == 200) {
                        Result.success(Unit)
                    } else {
                        Result.failure(Exception(responseBody?.errors?.values?.first()?.first()
                            ?: UNKNOWN_ERROR))
                    }
                } else {
                    Result.failure(Exception(response.errorBody()?.string() ?: UNKNOWN_ERROR))
                }
            }
        } catch (e: Exception) { Result.failure(Exception(NETWORK_ERROR)) }
    }
}
