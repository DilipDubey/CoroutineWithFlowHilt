package com.ril.fieldtravelclone.login_module

import android.util.Log
import com.ril.fieldtravelclone.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginRepository @Inject constructor(private val apiInterface1: APIInterface1) {

    suspend fun login()  = flow {
        val userName = "dilip.dubey"
        val password ="Harsh1234@"
        val scope = "openid"
        val grantType = "password"

        emit(NetworkResult1.Loading(true))
        Log.e("dkd","launch LoginRepository")

        var result=apiInterface1.login("application/x-www-form-urlencoded", BuildConfig.AUTH_TOKEN, grantType, userName, password, scope)
        Log.e("dkd","launch LoginRepository result-"+result)

        emit(NetworkResult1.Success(result))
    }.catch { e ->
        Log.e("dkd","launch LoginRepository error-"+e.message)

        emit(NetworkResult1.Error(e.message ?: "Unknown Error"))
    }.flowOn(Dispatchers.IO)
}