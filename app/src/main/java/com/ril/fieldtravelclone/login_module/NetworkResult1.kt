package com.ril.fieldtravelclone.login_module

sealed class NetworkResult1<T>{

    data class Loading<T>(private val loading: Boolean):NetworkResult1<T>()
    data class Success<T>(private val data:T):NetworkResult1<T>()
    data class Error<T>(private val error:String):NetworkResult1<T>()

}
